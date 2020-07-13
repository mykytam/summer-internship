package com.softserve2020practice.converters;

import com.softserve2020practice.dto.LessonByStudentIdResponseDto;
import com.softserve2020practice.models.Visit;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class LessonByStudentIdResponseDtoConverter implements Converter<Visit, LessonByStudentIdResponseDto> {

    @Override
    public LessonByStudentIdResponseDto convert(Visit source) {
        return LessonByStudentIdResponseDto.builder()
                .themeName(source.getLesson().getTheme().getName())
                .id(source.getLesson().getId())
                .presence(source.isPresence())
                .mark(source.getStudentMark())
                .comment(source.getComment())
                .studentGroupId(source.getStudent().getId())
                .localDate(source.getLesson().getLessonDate())
                .build();
    }
}
