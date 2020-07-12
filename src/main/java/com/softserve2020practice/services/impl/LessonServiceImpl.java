package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.LessonByStudentIdResponseDto;
import com.softserve2020practice.dto.LessonCreateDto;
import com.softserve2020practice.dto.LessonResponseDto;
import com.softserve2020practice.dto.LessonUpdateDto;
import com.softserve2020practice.exceptions.StudentGroupNotFoundException;
import com.softserve2020practice.exceptions.StudentNotFoundException;
import com.softserve2020practice.models.*;
import com.softserve2020practice.repositories.*;
import com.softserve2020practice.services.LessonService;
import com.softserve2020practice.services.UserDetailsExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final ThemeRepository themeRepository;
    private final LessonRepository lessonRepository;
    private final ConversionService conversionService;
    private final StudentRepository studentRepository;
    private final StudentGroupRepository studentGroupRepository;
    private final UserDetailsExtractor userDetailsExtractor;
    private final MentorRepository mentorRepository;

    @Override
    public List<LessonResponseDto> getAllLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(lesson -> conversionService.convert(lesson, LessonResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addLesson(LessonCreateDto lessonCreateDto) {
        Theme theme = themeRepository.findByName(lessonCreateDto.getThemeName());
        Set<Visit> visits = lessonCreateDto.getLessonsVisits().stream()
                .map(visitDtoCreate -> {
                    Visit visit = conversionService.convert(visitDtoCreate, Visit.class);
                    Student student = studentRepository.findById(visitDtoCreate.getStudentId())
                            .orElseThrow(() -> new StudentNotFoundException("Student not found"));
                    visit.setStudent(student);
                    return visit;
                })
                .collect(Collectors.toSet());

        StudentGroup studentGroup = studentGroupRepository.findById(lessonCreateDto.getGroupId())
                .orElseThrow(() -> new StudentGroupNotFoundException("Student group not found!"));

        Mentor mentor = mentorRepository.findByIdAccount_Id(userDetailsExtractor.extractJwtUser().getId());

        Lesson lesson = Lesson.builder()
                .theme(theme)
                .studentGroup(studentGroup)
                .lessonDate(lessonCreateDto.getLessonDate())
                .mentor(mentor)
                .build();

        visits.forEach(lesson::addVisit);

        lessonRepository.save(lesson);
    }

    @Override
    public void updateLesson(Long id, LessonUpdateDto lessonUpdateDto) {

        Lesson lesson = lessonRepository.findById(id).orElseThrow(RuntimeException::new);
        Mentor mentor = mentorRepository.findByIdAccount_Id(userDetailsExtractor.extractJwtUser().getId());

        if (lessonUpdateDto.getLessonsVisits() != null) {
            Set<Visit> visits = lessonUpdateDto.getLessonsVisits().stream()
                    .map(visitDtoCreate -> {
                        Visit visit = conversionService.convert(visitDtoCreate, Visit.class);
                        Student student = studentRepository.findById(visitDtoCreate.getStudentId())
                                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
                        visit.setStudent(student);
                        return visit;
                    })
                    .collect(Collectors.toSet());

            lesson.deleteForUpdate();

            for (Visit toAdd : visits) {
                lesson.addVisit(toAdd);
            }
        }

        if (lessonUpdateDto.getThemeName() != null) {
            lesson.setTheme(themeRepository.findByName(lessonUpdateDto.getThemeName()));
        }
        if (lessonUpdateDto.getLessonDate() != null) {
            lesson.setLessonDate(lessonUpdateDto.getLessonDate());
        }
        if (mentor != null) {
            lesson.setMentor(mentor);
        }

        lessonRepository.save(lesson);
    }

    @Override
    public List<LessonByStudentIdResponseDto> getLessonsByStudentId(Long id) {
        List<Visit> visits = studentRepository.findById(id).orElseThrow(RuntimeException::new).getStudentVisit();
        return visits.stream()
                .map(lesson -> conversionService.convert(lesson, LessonByStudentIdResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

}
