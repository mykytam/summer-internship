package com.softserve2020practice.converters;


import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.models.StudentGroup;
import org.springframework.core.convert.converter.Converter;

public class StudentGroupToResponseDtoConverter implements Converter<StudentGroup, StudentGroupResponseDto> {

    @Override
    public StudentGroupResponseDto convert(StudentGroup studentGroup) {

        return StudentGroupResponseDto.builder()
                .name(studentGroup.getName())
                .startDate(studentGroup.getStartDate())
                .finishDate(studentGroup.getFinishDate())
                .courses(studentGroup.getCourses())
                .students(studentGroup.getStudents())
                .build();
    }
}
