package com.softserve2020practice.security.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TokenStore {

    private final Map<String, LocalDateTime> tokenStoreMap = new ConcurrentHashMap<>();

    @Value("${security.token-ttl}")
    private Long tokenTtl;

    public void putToken(String token) {
        tokenStoreMap.put(token, LocalDateTime.now());
    }

    public void removeToken(String token) {
        tokenStoreMap.remove(token);
    }

    public boolean isExpired(String token) {
        LocalDateTime localDateTime = tokenStoreMap.get(token);
        if (localDateTime != null) {
            return localDateTime.plusMinutes(tokenTtl).isBefore(LocalDateTime.now());
        } else {
            return true;
        }
    }

    // TODO: schedule removing expired tokens once a day or another period
}
