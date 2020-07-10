package com.softserve2020practice.security.auth;

import com.softserve2020practice.services.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationTokenProviderImpl implements AuthenticationTokenProvider {

    private final UserDetailsService userDetailsService;
    private final JwtTokenService jwtTokenService;

    @Override
    public Authentication getAuthentication(String token) {
        String email = jwtTokenService.extractSubject(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}
