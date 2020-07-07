package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class MentorResponseDto {

    @NotNull
    private Long id;

    @NotNull
    private Long idAccount;

    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Boolean isActive;

}
