package com.softserve2020practice.controllers;

import com.softserve2020practice.dto.LoginRequestDto;
import com.softserve2020practice.dto.LoginResponseDto;
import com.softserve2020practice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.softserve2020practice.constants.Headers.AUTH_HEADER;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.authenticate(loginRequestDto);
    }

    @DeleteMapping
    public void logout(@RequestHeader(AUTH_HEADER) String header) {
        authService.logout(header);
    }

}
