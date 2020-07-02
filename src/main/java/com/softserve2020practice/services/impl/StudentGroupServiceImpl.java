package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.exceptions.StudentGroupNotFoundException;
import com.softserve2020practice.models.Student;
import com.softserve2020practice.models.StudentGroup;
import com.softserve2020practice.repositories.StudentGroupRepository;
import com.softserve2020practice.repositories.StudentRepository;
import com.softserve2020practice.services.StudentGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;
    private final ConversionService conversionService;
    private final StudentRepository studentRepository;

    @Override
    public StudentGroupResponseDto createStudentGroup(StudentGroupRequestDto studentGroupRequestDto) {

        StudentGroup studentGroup = conversionService.convert(studentGroupRequestDto, StudentGroup.class);

        studentGroup.setName(studentGroupRequestDto.getName());
        studentGroup.setStartDate(studentGroupRequestDto.getStartDate());
        studentGroup.setFinishDate(studentGroupRequestDto.getFinishDate());
        studentGroup.setCourses(studentGroupRequestDto.getCourses());

        Set<String> emails = studentGroupRequestDto.getEmails();
        Set<Student> students = new HashSet<>();

        for (String email : emails) {
            students.add(studentRepository.findByEmail(email));
        }

        studentGroup.setStudents(students);

        StudentGroup savedStudentGroup = studentGroupRepository.save(studentGroup);

        return conversionService.convert(savedStudentGroup, StudentGroupResponseDto.class);
    }

    @Override
    public List<StudentGroupResponseDto> findStudentGroup() {
        return studentGroupRepository.findAll()
                .stream()
                .map(studentGroup -> conversionService.convert(studentGroup, StudentGroupResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentGroupResponseDto findStudentGroupById(Long id) {
        StudentGroup studentGroup = studentGroupRepository.findById(id)
                .orElseThrow(() -> new StudentGroupNotFoundException("Student group not found!"));

        return conversionService.convert(studentGroup, StudentGroupResponseDto.class);
    }

    @Override
    public StudentGroupResponseDto updateStudentGroup(StudentGroupRequestDto studentGroupRequestDto, Long id) {
        StudentGroup studentGroup = studentGroupRepository.findById(id)
                .orElseThrow(() -> new StudentGroupNotFoundException("Student group not found!"));

        studentGroup.setName(studentGroupRequestDto.getName());
        studentGroup.setStartDate(studentGroupRequestDto.getStartDate());
        studentGroup.setFinishDate(studentGroupRequestDto.getFinishDate());
        studentGroup.setCourses(studentGroupRequestDto.getCourses());

        Set<String> emails = studentGroupRequestDto.getEmails();
        Set<Student> students = new HashSet<>();

        for (String email : emails) {
            students.add(studentRepository.findByEmail(email));
        }

        studentGroup.setStudents(students);

        StudentGroup savedStudentGroup = studentGroupRepository.save(studentGroup);

        return conversionService.convert(savedStudentGroup, StudentGroupResponseDto.class);
    }

    @Override
    public void deleteStudentGroup(Long id) {
        studentGroupRepository.deleteById(id);
    }
}
