package com.softserve2020practice.security.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenValidator {

    private final TokenStore tokenStore;

    public boolean isValid(String token) {
        return refreshToken(token);
    }

    /**
     * Method to refresh token if needed.
     *
     * @param token token to refresh
     * @return true if token successfully refreshed
     */
    private boolean refreshToken(String token) {
        if (!tokenStore.isExpired(token)) {
            tokenStore.putToken(token);
            return true;
        } else {
            tokenStore.removeToken(token);
            return false;
        }
    }

}
