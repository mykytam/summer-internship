package com.softserve2020practice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CourseRequestDto {

    @NotBlank
    private String name;

}
