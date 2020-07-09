package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.StudentCreateDto;
import com.softserve2020practice.dto.StudentIdResponseDto;
import com.softserve2020practice.dto.StudentResponseDto;
import com.softserve2020practice.dto.StudentUpdateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Student;
import com.softserve2020practice.models.StudentGroup;
import com.softserve2020practice.models.enums.Role;
import com.softserve2020practice.repositories.StudentGroupRepository;
import com.softserve2020practice.repositories.StudentRepository;
import com.softserve2020practice.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.softserve2020practice.services.impl.PasswordGenerator.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentGroupRepository studentGroupRepository;
    private final ConversionService conversionService;

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(students -> conversionService.convert(students, StudentResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentIdResponseDto> getStudentById() {
        return null;
    }

    @Override
    public Long addStudent(StudentCreateDto studentDto) {

        Student student = conversionService.convert(studentDto, Student.class);
        Account account = student.getIdAccount();

        account.setRole(Role.STUDENT);
        account.setPassword(generatePassword());
        account.setSalt(generateSalt());
        account.setActive(true);

        studentRepository.save(student);

        return student.getId();
    }

    @Override
    public void updateStudent(Long id, StudentUpdateDto studentDto) {

        Student toUpdate = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        Account account = toUpdate.getIdAccount();

        List<StudentGroup> coursesFromDto = studentGroupRepository.findAllById(studentDto.getGroupsId());
        for (StudentGroup toAdd : coursesFromDto) {
            toUpdate.deleteForUpdate();
            toUpdate.addStudentToGroup(toAdd);
        }

        account.setEmail(studentDto.getEmail());
        account.setFirstName(studentDto.getFirstName());
        account.setLastName(studentDto.getLastName());
        account.setPassword(updatePassword(studentDto.getEmail()));

        studentRepository.save(toUpdate);
    }

    @Override
    public void deleteStudent(Long id) {

        Student toDeactivate = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        Account account = toDeactivate.getIdAccount();
        account.setActive(false);

        studentRepository.save(toDeactivate);
    }
}
