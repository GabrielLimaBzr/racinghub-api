package com.application.racinghub.common.infra.config.security.domain.jwt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JwtTokenService {

    @Value("${api.security.token.secret}")
    private String secretKey;
    @Value("${api.security.token.hours_to_expire}")
    private int hoursToExpire;

    public String createJwtToken(String email) {
        try {
            return JWT.create()
                    .withIssuer("racinghub-api")
                    .withSubject(email)
                    .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.of("-03:00")))
                    .withExpiresAt(LocalDateTime.now().plusHours(hoursToExpire).toInstant(ZoneOffset.of("-03:00")))
                    .sign(getAlgorithm(secretKey));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o Token JWT", exception);
        }
    }

    public String validateJwtToken(String jwtToken) {
        try {
            return JWT.require(getAlgorithm(secretKey))
                    .withIssuer("racinghub-api")
                    .build()
                    .verify(jwtToken)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Algorithm getAlgorithm(String secretKey) {
        return Algorithm.HMAC256(secretKey);
    }
}
