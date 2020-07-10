package com.softserve2020practice.services.impl;

import com.softserve2020practice.models.Account;
import com.softserve2020practice.repositories.AccountRepository;
import com.softserve2020practice.security.data.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return conversionService.convert(account, JwtUser.class);
    }

}
