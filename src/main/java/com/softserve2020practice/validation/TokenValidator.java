package com.softserve2020practice.validation;

import com.softserve2020practice.security.token.TokenStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.softserve2020practice.constants.Headers.AUTH_HEADER_PREFIX;

@Component
@RequiredArgsConstructor
public class TokenValidator {

    private final TokenStore tokenStore;

    public boolean isValid(String token) {
        if (token == null || token.length() < AUTH_HEADER_PREFIX.length()) {
            return false;
        }
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
