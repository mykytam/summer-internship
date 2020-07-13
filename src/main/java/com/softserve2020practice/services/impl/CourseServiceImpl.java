package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseRequestDto;
import com.softserve2020practice.dto.CourseResponseDto;
import com.softserve2020practice.exceptions.AlreadyExistException;
import com.softserve2020practice.exceptions.CourseNotFoundException;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ConversionService conversionService;

    @Override
    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> conversionService.convert(course, CourseResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addCourse(CourseCreateDto courseCreateDto) {
        if (courseRepository.existsByName(courseCreateDto.getName())) {
            throw new AlreadyExistException("Course already exist!");
        } else {
            Course course = new Course();
            course.setName(courseCreateDto.getName());
            courseRepository.save(course);
        }
    }

    @Override
    public void updateCourse(CourseRequestDto courseRequestDto, Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found!"));
        course.setName(courseRequestDto.getName());
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found!"));
        courseRepository.delete(course);
    }
}
