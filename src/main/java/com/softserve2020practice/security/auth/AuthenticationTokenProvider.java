package com.softserve2020practice.security.auth;

import org.springframework.security.core.Authentication;

public interface AuthenticationTokenProvider {
    Authentication getAuthentication(String token);
}
