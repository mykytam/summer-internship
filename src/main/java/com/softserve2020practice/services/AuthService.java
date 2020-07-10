package com.softserve2020practice.services;

import com.softserve2020practice.dto.LoginRequestDto;
import com.softserve2020practice.dto.LoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<LoginResponseDto> authenticate(LoginRequestDto loginRequestDto);
}
