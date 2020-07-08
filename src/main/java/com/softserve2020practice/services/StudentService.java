package com.softserve2020practice.services;

import com.softserve2020practice.dto.StudentCreateDto;
import com.softserve2020practice.dto.StudentIdResponseDto;
import com.softserve2020practice.dto.StudentResponseDto;
import com.softserve2020practice.dto.StudentUpdateDto;

import java.util.List;

public interface StudentService {

    List<StudentResponseDto> getAllStudents();

    List<StudentIdResponseDto> getStudentById();

    Long addStudent(StudentCreateDto studentDto);

    void updateStudent(Long id, StudentUpdateDto studentDto);

    void deleteStudent(Long id);
}
