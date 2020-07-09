package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class StudentResponseDto {

    @NonNull
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
