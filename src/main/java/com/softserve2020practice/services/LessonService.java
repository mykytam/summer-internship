package com.softserve2020practice.services;

import com.softserve2020practice.dto.LessonByStudentIdResponseDto;
import com.softserve2020practice.dto.LessonCreateDto;
import com.softserve2020practice.dto.LessonResponseDto;
import com.softserve2020practice.dto.LessonUpdateDto;

import java.util.List;

public interface LessonService {

    List<LessonResponseDto> getAllLessons();

    void addLesson(LessonCreateDto lessonCreateDto);

    void updateLesson(Long id, LessonUpdateDto lessonUpdateDto);

    List<LessonByStudentIdResponseDto> getLessonsByStudentId(Long id);

    void deleteLesson(Long id);
}
