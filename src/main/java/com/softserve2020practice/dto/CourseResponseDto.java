package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CourseResponseDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

}
