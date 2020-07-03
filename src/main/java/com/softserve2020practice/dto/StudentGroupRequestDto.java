package com.softserve2020practice.dto;

import com.softserve2020practice.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupRequestDto {

    private String name;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Set<Course> courses;

    private Set<String> emails;

}
