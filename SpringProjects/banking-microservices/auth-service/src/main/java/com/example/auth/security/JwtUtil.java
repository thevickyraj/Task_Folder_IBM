package com.example.auth.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Issues JWTs for authenticated users.
 *
 * IMPORTANT: this SECRET must be byte-for-byte identical to the one in
 * gateway-service's JwtAuthFilter.java. If the two ever drift apart, every
 * token this service issues will be rejected as "Invalid token" at the
 * gateway. In a real deployment, load this from a shared secret store
 * (Vault, AWS Secrets Manager, an env var injected into both services) —
 * it's duplicated as a literal here only to keep this example dependency-free.
 */
@Component
public class JwtUtil {

    private static final String SECRET = "change-this-to-a-long-random-secret-key-min-32-bytes!!";
    private static final SecretKey SIGNING_KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    private static final long EXPIRY_HOURS = 24;

    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiry = now.plus(EXPIRY_HOURS, ChronoUnit.HOURS);

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiry))
                .signWith(SIGNING_KEY)
                .compact();
    }

    public long expiryEpochMillis() {
        return Instant.now().plus(EXPIRY_HOURS, ChronoUnit.HOURS).toEpochMilli();
    }
}
