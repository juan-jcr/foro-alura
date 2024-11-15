package com.foro.infrastructure.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foro.domain.exception.ResourceNotFoundException;
import com.foro.domain.model.Author;
import com.foro.domain.port.IAuthorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${security.jwt.key.private}")
    private String SECRET_KEY;

    private static final long EXPIRATION_TIME = 86400000;

    @Autowired
    private IAuthorPersistence persistence;

    public String generateToken(String email, String name) {
        return JWT.create()
                .withSubject(email)
                .withClaim("name", name)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public Author getAuthenticatedUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return persistence.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));

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
