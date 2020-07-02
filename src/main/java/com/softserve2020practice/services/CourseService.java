package com.softserve2020practice.services;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseUpdateDto;
import com.softserve2020practice.models.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    void addCourse(CourseCreateDto name);

    void updateCourse(CourseUpdateDto courseUpdateDto);

    void deleteCourse(Long id);

}
