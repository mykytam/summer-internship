package com.softserve2020practice.dto;


import com.softserve2020practice.models.Course;
import com.softserve2020practice.models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupResponseDto {

    private String name;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Set<Course> courses;

    private Set<Student> students;

}
