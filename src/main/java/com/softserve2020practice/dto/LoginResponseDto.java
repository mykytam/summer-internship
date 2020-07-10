package com.softserve2020practice.dto;

import lombok.Value;

@Value
public class LoginResponseDto {

    Long id;
    String firstName;
    String lastName;
    Integer role;

}
