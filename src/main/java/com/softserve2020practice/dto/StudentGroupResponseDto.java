package com.softserve2020practice.dto;


import com.softserve2020practice.models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupResponseDto {

    @NotBlank
    private Set<String> mentors;

    @NotBlank
    private String groupName;

    @NotNull
    private Set<Account> students;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate finishDate;

}
