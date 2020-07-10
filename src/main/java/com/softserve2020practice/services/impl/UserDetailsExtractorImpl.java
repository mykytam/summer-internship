package com.softserve2020practice.services.impl;

import com.softserve2020practice.security.data.JwtUser;
import com.softserve2020practice.services.UserDetailsExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsExtractorImpl implements UserDetailsExtractor {

    @Override
    public JwtUser extractJwtUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof JwtUser) {
            return (JwtUser) authentication.getPrincipal();
        }
        return null;
    }

}
