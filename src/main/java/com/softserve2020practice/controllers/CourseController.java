package com.softserve2020practice.controllers;

import com.softserve2020practice.dto.CourseCreateDto;
import com.softserve2020practice.dto.CourseUpdateDto;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCourse(@Valid @RequestBody CourseCreateDto courseCreateDto) {
        courseService.addCourse(courseCreateDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody CourseUpdateDto courseUpdateDto) {
        courseService.updateCourse(courseUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
