package com.softserve2020practice.controllers;

import com.softserve2020practice.annotations.Access;
import com.softserve2020practice.dto.StudentCreateDto;
import com.softserve2020practice.dto.StudentIdResponseDto;
import com.softserve2020practice.dto.StudentResponseDto;
import com.softserve2020practice.dto.StudentUpdateDto;
import com.softserve2020practice.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Access.Mentor
    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Access.Mentor
    @GetMapping("{id}")
    public StudentIdResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @Access.Mentor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createStudent(@RequestBody @Valid StudentCreateDto student) {
        return studentService.addStudent(student);
    }

    @Access.Mentor
    @PutMapping("{id}")
    public void updateMentor(@PathVariable Long id, @RequestBody StudentUpdateDto student) {
        studentService.updateStudent(id, student);
    }

    @Access.Mentor
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMentor(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
