package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToResponseDtoConverter implements Converter<Student, StudentResponseDto> {
    @Override
    public StudentResponseDto convert(Student source) {

        Account account = source.getIdAccount();

        return StudentResponseDto.builder()
                .id(source.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .build();
    }
}
