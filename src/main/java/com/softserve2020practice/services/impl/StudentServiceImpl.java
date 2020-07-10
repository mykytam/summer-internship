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
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.softserve2020practice.services.PasswordUtil.*;

@Service
@RequiredArgsConstructor
@Slf4j
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
    public StudentIdResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException());

        return conversionService.convert(student, StudentIdResponseDto.class);
    }

    @Override
    public Long addStudent(StudentCreateDto studentDto) {

        Student student = conversionService.convert(studentDto, Student.class);
        Account account = student.getIdAccount();

        String password = generatePassword();
        String salt = generateSalt();

        log.info("Generated password: {}", password); // TODO: don't log password! Send it to email

        account.setRole(Role.STUDENT);
        account.setPassword(hashPassword(password, salt));
        account.setSalt(salt);
        account.setActive(true);

        studentRepository.save(student);

        return student.getId();
    }

    @Override
    public void updateStudent(Long id, StudentUpdateDto studentDto) {

        Student toUpdate = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        Account account = toUpdate.getIdAccount();

        if (studentDto.getStudentGroupIds() != null) {
            List<StudentGroup> coursesFromDto = studentGroupRepository.findAllById(studentDto.getStudentGroupIds());
            for (StudentGroup toAdd : coursesFromDto) {
                toUpdate.deleteForUpdate();
                toUpdate.addStudentToGroup(toAdd);
            }
        }

        if (studentDto.getEmail() != null) {
            account.setEmail(studentDto.getEmail());
        }
        if (studentDto.getFirstName() != null) {
            account.setFirstName(studentDto.getFirstName());
        }
        if (studentDto.getLastName() != null) {
            account.setLastName(studentDto.getLastName());
        }
        if (studentDto.getEmail() != null) {
            account.setEmail(studentDto.getEmail());
        }

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
