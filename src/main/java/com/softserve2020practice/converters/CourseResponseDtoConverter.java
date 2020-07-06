package com.softserve2020practice.converters;

import com.softserve2020practice.dto.CourseResponseDto;
import com.softserve2020practice.models.Course;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class CourseResponseDtoConverter implements Converter<Course, CourseResponseDto> {

    @Override
    public CourseResponseDto convert(Course source) {
        return CourseResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

}
