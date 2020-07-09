package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class StudentCreateDto {

    @NotBlank
    private String email;

}
