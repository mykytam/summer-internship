package com.softserve2020practice.controllers;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseRequestDto;
import com.softserve2020practice.dto.CourseResponseDto;
import com.softserve2020practice.security.Access;
import com.softserve2020practice.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    @Access.AdminAndMentor
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    @Access.Admin
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@Valid @RequestBody CourseCreateDto courseCreateDto) {
        courseService.addCourse(courseCreateDto);
    }

    @PutMapping(value = "{id}")
    @Access.Admin
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@Valid @RequestBody CourseRequestDto courseRequestDto, @PathVariable Long id) {
        courseService.updateCourse(courseRequestDto, id);
    }

    @DeleteMapping(value = "{id}")
    @Access.Admin
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
