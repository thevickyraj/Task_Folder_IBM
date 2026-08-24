package com.example.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RouteConfig {

    @Bean
    @Primary
    public RedisRateLimiter accountRateLimiter() {
        return new RedisRateLimiter(1, 1);
    }

    @Bean
    public RedisRateLimiter transactionRateLimiter() {
        return new RedisRateLimiter(3, 6);
    }

    @Bean
    public RouteLocator routes(
            RouteLocatorBuilder builder,
            KeyResolver userKeyResolver,
            RedisRateLimiter accountRateLimiter,
            RedisRateLimiter transactionRateLimiter) {

        return builder.routes()

                // Auth Service
                .route("auth_route", r -> r.path("/auth", "/auth/**")
                        .uri("http://localhost:8081"))

                // Create Account - keep /account
                .route("account_create_route", r -> r.path("/account")
                        .uri("http://localhost:8082"))

                // Account Service
                .route("account_route", r -> r.path("/account/**")
                        .filters(f -> f
                                .stripPrefix(1)

                                .requestRateLimiter(config -> config
                                        .setRateLimiter(accountRateLimiter)
                                        .setKeyResolver(userKeyResolver))

                                .circuitBreaker(c -> c
                                        .setName("accountCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/account")))
                        .uri("http://localhost:8082"))

                // Transaction Service
                .route("transaction_route", r -> r.path("/transaction/**")
                        .filters(f -> f

                                .stripPrefix(1)

                                .requestRateLimiter(config -> config
                                        .setRateLimiter(transactionRateLimiter)
                                        .setKeyResolver(userKeyResolver))

                                .circuitBreaker(c -> c
                                        .setName("transactionCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/transaction")))
                        .uri("http://localhost:8083"))

                .build();
    }
}