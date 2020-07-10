package com.softserve2020practice.converters;

import com.google.common.collect.Lists;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.security.data.JwtUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AccountToJwtUserConverter implements Converter<Account, JwtUser> {
    @Override
    public JwtUser convert(Account account) {
        return JwtUser.builder()
                .id(account.getId())
                .email(account.getEmail())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .enabled(account.getIsActive())
                .password(account.getPassword())
                .authorities(Lists.newArrayList(new SimpleGrantedAuthority(account.getRole().name())))
                .build();
    }
}
