package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class StudentIdResponseDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String groupName;

    @NotBlank
    private String courseName;

//    lessons - array of objects
//    theme - string
//    mentor - object
//    first_name - string
//    last_name - string
//    date - datetime

}
