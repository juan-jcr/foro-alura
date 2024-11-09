package com.foro.infrastructure.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "my_secret_key_foro_alura"; // Cambiar esto más tarde
    private static final long EXPIRATION_TIME = 86400000;

    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(SECRET_KEY))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
