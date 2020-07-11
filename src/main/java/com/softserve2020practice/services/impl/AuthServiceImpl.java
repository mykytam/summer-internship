package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.LoginRequestDto;
import com.softserve2020practice.dto.LoginResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.repositories.AccountRepository;
import com.softserve2020practice.services.AuthService;
import com.softserve2020practice.services.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.softserve2020practice.constants.Headers.AUTH_HEADER;
import static com.softserve2020practice.services.impl.PasswordUtil.hashPassword;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final JwtTokenService jwtTokenService;

    @Override
    public ResponseEntity<LoginResponseDto> authenticate(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, hashPassword(password, account.getSalt())));

        String token = jwtTokenService.createToken(email);

        LoginResponseDto loginResponseDto = new LoginResponseDto(
                account.getId(),
                account.getFirstName(),
                account.getLastName(),
                account.getRole().getValue()
        );

        return ResponseEntity.ok().header(AUTH_HEADER, token).body(loginResponseDto);
    }

}
