package com.softserve2020practice.converters;

import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Mentor;
import com.softserve2020practice.models.Student;
import com.softserve2020practice.models.StudentGroup;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentGroupToResponseDtoConverter implements Converter<StudentGroup, StudentGroupResponseDto> {
    @Override
    public StudentGroupResponseDto convert(StudentGroup studentGroup) {

        Set<String> mentorsNames = studentGroup.getMentors()
                .stream()
                .map(Mentor::getIdAccount)
                .map(Account::getFirstName)
                .collect(Collectors.toSet());

        Set<Account> students = studentGroup.getStudents()
                .stream()
                .map(Student::getIdAccount)
                .collect(Collectors.toSet());


        return StudentGroupResponseDto.builder()
                .mentors(mentorsNames)
                .groupName(studentGroup.getName())
                .students(students)
                .startDate(studentGroup.getStartDate())
                .finishDate(studentGroup.getFinishDate())
                .build();
    }
}
