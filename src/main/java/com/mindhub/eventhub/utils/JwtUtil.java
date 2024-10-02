package com.mindhub.eventhub.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    /*@Value("${jwt.secret}")
    private String secret;*/

    public JwtUtil() {
        byte[] keyBytes = new byte[32];

        new SecureRandom().nextBytes(keyBytes);

        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(Base64.getEncoder().encodeToString(keyBytes)));

        System.out.println("\n" + Base64.getEncoder().encodeToString(keyBytes) + "\n");
    }


    public String generateToken(String email) {
        return Jwts.builder()
            .subject(email)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(secretKey, Jwts.SIG.HS256)
            .compact();
    }

    public String extractEmail(String token) {
        return parseClaims(token).getSubject();
    }

    public boolean validateToken(String token, String email) {
        final String tokenUsername = extractEmail(token);
        return (tokenUsername.equals(email) && !isTokenExpired(token));
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    private boolean isTokenExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }
}
