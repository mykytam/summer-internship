package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.models.StudentGroup;
import org.springframework.core.convert.converter.Converter;

public class StudentGroupRequestDtoToStudentGroup implements Converter<StudentGroupRequestDto, StudentGroup> {

    @Override
    public StudentGroup convert(StudentGroupRequestDto studentGroupRequestDto) {
        return StudentGroup.builder()
                .name(studentGroupRequestDto.getName())
                .startDate(studentGroupRequestDto.getStartDate())
                .finishDate(studentGroupRequestDto.getFinishDate())
                .build();
    }
}
