package com.softserve2020practice.converters;

import com.softserve2020practice.dto.LessonResponseDto;
import com.softserve2020practice.models.Lesson;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class LessonResponseDtoConverter implements Converter<Lesson, LessonResponseDto> {

    @Override
    public LessonResponseDto convert(Lesson source) {
        return LessonResponseDto.builder()
                .id(source.getId())
                .themeName(source.getTheme().getName())
                .lessonDate(source.getLessonDate())
                .build();
    }

}
