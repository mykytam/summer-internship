package com.softserve2020practice.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.softserve2020practice.dto.LoginRequestDto;
import com.softserve2020practice.dto.LoginResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.repositories.AccountRepository;
import com.softserve2020practice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.softserve2020practice.constants.Headers.AUTH_HEADER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<LoginResponseDto> authenticate(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        // TODO: pass hashed password
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        // TODO: sign with secret from properties
        String token = JWT.create().withSubject(email).sign(Algorithm.HMAC512("secret"));

        LoginResponseDto loginResponseDto = new LoginResponseDto(
                account.getId(),
                account.getFirstName(),
                account.getLastName(),
                account.getRole().getValue()
        );

        return ResponseEntity.ok().header(AUTH_HEADER, token).body(loginResponseDto);
    }

}
