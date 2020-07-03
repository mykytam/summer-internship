package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseUpdateDto;
import com.softserve2020practice.exceptions.AlreadyExistException;
import com.softserve2020practice.exceptions.NotFoundIdException;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseRepository.findAll());
    }

    @Override
    public void addCourse(CourseCreateDto courseCreateDto) {
        if (courseRepository.existsByName(courseCreateDto.getName())) {
            throw new AlreadyExistException();
        } else {
            Course course = new Course();
            course.setName(courseCreateDto.getName());
            courseRepository.save(course);
        }
    }

    @Override
    public void updateCourse(CourseUpdateDto courseUpdateDto) {
        Course course = courseRepository.findById(courseUpdateDto.getId()).orElseThrow(NotFoundIdException::new);
        course.setName(courseUpdateDto.getName());
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(NotFoundIdException::new);
        courseRepository.delete(course);
    }
}
