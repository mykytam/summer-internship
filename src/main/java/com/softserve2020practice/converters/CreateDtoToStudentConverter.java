package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentCreateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateDtoToStudentConverter implements Converter<StudentCreateDto, Student> {
    @Override
    public Student convert(StudentCreateDto source) {

        Account build = Account.builder()
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .build();

        return Student.builder().idAccount(build)
                .build();
    }
}
