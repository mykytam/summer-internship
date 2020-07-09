package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentUpdateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateDtoToStudentConverter implements Converter<StudentUpdateDto, Student> {
    @Override
    public Student convert(StudentUpdateDto source) {

        Account build = Account.builder()
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .build();

        return Student.builder().idAccount(build)
                .build();
    }
}
