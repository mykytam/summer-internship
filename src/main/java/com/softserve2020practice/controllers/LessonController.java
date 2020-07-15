package com.softserve2020practice.controllers;

import com.softserve2020practice.annotations.Access;
import com.softserve2020practice.dto.LessonByStudentIdResponseDto;
import com.softserve2020practice.dto.LessonCreateDto;
import com.softserve2020practice.dto.LessonResponseDto;
import com.softserve2020practice.dto.LessonUpdateDto;
import com.softserve2020practice.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    @Access.Mentor
    @ResponseStatus(HttpStatus.OK)
    public List<LessonResponseDto> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping(value = "/students/{id}")
    @Access.MentorAndStudent
    @ResponseStatus(HttpStatus.OK)
    public List<LessonByStudentIdResponseDto> getLessonsByStudentId(@PathVariable Long id) {
        return lessonService.getLessonsByStudentId(id);
    }

    @PostMapping
    @Access.Mentor
    @ResponseStatus(HttpStatus.CREATED)
    public void createLesson(@Valid @RequestBody LessonCreateDto lessonCreateDto) {
        lessonService.addLesson(lessonCreateDto);
    }

    @PutMapping(value = "{id}")
    @Access.Mentor
    @ResponseStatus(HttpStatus.OK)
    public void updateLesson(@Valid @RequestBody LessonUpdateDto lessonUpdateDto, @PathVariable Long id) {
        lessonService.updateLesson(id, lessonUpdateDto);
    }

    @DeleteMapping(value = "{id}")
    @Access.Mentor
    @ResponseStatus(HttpStatus.OK)
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }

}
