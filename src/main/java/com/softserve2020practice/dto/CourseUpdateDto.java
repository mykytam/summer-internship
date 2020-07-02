package com.softserve2020practice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseUpdateDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

}
