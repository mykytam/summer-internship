package com.softserve2020practice.services;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {

    List<CourseResponseDto> getAllCourses();

    void addCourse(CourseCreateDto name);

    void updateCourse(CourseResponseDto courseResponseDto);

    void deleteCourse(Long id);

}
