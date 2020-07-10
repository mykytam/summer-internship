package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@Builder
public class MentorCreateDto {

    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "Invalid email"
    )
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Set<Long> courseIds;

}
