package com.softserve2020practice.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.softserve2020practice.constants.Headers;
import com.softserve2020practice.services.JwtTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${security.token-secret}")
    private String tokenSecret;

    @Override
    public String createToken(String subject) {
        return JWT.create()
                .withSubject(subject)
                .withJWTId(UUID.randomUUID().toString())
                .sign(Algorithm.HMAC512(tokenSecret));
    }

    @Override
    public String extractSubject(String token) {
        return getDecodedJwt(token).getSubject();
    }

    @Override
    public String extractToken(String header) {
        return header.substring(Headers.AUTH_HEADER_PREFIX.length());
    }

    private DecodedJWT getDecodedJwt(String token) {
        return JWT.require(Algorithm.HMAC512(tokenSecret)).build().verify(token);
    }
}
