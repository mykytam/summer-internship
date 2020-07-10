package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class MentorUpdateDto {

    private String email;

    private String firstName;

    private String lastName;

    private Set<Long> courseIds;

    private String password;
}
