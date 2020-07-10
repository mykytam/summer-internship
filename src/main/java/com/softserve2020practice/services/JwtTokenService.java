package com.softserve2020practice.services;

public interface JwtTokenService {

    String createToken(String subject);

    String extractSubject(String token);

}
