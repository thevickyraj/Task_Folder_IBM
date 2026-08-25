package com.example.gateway.filter;

import com.example.gateway.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements GlobalFilter, Ordered {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String path = exchange.getRequest()
                .getURI()
                .getPath();

        // Login and register are public
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }

        // Get Authorization header
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        // No JWT
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // Extract token
        String token = authHeader.substring(7);

        // Validate JWT
        if (!jwtUtil.validateToken(token)) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // Get JWT claims
        Claims claims = jwtUtil.getClaims(token);

        String username = claims.getSubject();

        String jwtRole = claims.get("role", String.class);

        // Create a new final/effectively-final variable
        final String role = jwtRole != null ? jwtRole : "USER";

        // Add user information to downstream request
        ServerWebExchange modifiedExchange =
                exchange.mutate()
                        .request(request -> request
                                .header("X-User-Id", username)
                                .header("X-User-Role", role))
                        .build();

        return chain.filter(modifiedExchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}