package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentIdResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Student;
import com.softserve2020practice.models.StudentGroup;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentIdToResponseDtoConverter implements Converter<Student, StudentIdResponseDto> {

    @Override
    public StudentIdResponseDto convert(Student source) {

        Account account = source.getIdAccount();

        return StudentIdResponseDto.builder()
                .email(account.getEmail())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .studentGroupIds(source.getGroupStudents().stream().map(StudentGroup::getId).collect(Collectors.toSet()))
                .build();
    }
}
