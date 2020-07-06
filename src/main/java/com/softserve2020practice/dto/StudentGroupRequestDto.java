package com.softserve2020practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate finishDate;

    @NotNull
    private Long courseId;

    @NotNull
    private List<Long> studentId;

}
