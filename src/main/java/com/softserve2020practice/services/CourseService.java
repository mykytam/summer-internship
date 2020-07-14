package com.softserve2020practice.services;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseRequestDto;
import com.softserve2020practice.dto.CourseResponseDto;

import java.util.List;

public interface CourseService {

    List<CourseResponseDto> getAllCourses();

    void addCourse(CourseCreateDto name);

    void updateCourse(CourseRequestDto courseRequestDto, Long id);

    void deleteCourse(Long id);

}
