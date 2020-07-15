package com.softserve2020practice.controllers;

import com.softserve2020practice.annotations.Access;
import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.services.StudentGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/student_groups")
@RestController
@RequiredArgsConstructor
public class StudentGroupController {

    private final StudentGroupService studentGroupService;

    @PostMapping
    @Access.Mentor
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudentGroup(@RequestBody @Valid StudentGroupRequestDto studentGroup) {
        studentGroupService.createStudentGroup(studentGroup);
    }

    @Access.Mentor
    @GetMapping
    public List<StudentGroupResponseDto> findStudentGroup() {
        return studentGroupService.findAllStudentGroups();
    }

    @Access.Mentor
    @GetMapping("{id}")
    public StudentGroupResponseDto findStudentGroupById(@PathVariable Long id) {
        return studentGroupService.findStudentGroupById(id);
    }

    @Access.Mentor
    @PutMapping("{id}")
    public void updateStudentGroup(@PathVariable Long id, @Valid StudentGroupRequestDto studentGroupRequestDto) {
        studentGroupService.updateStudentGroup(studentGroupRequestDto, id);
    }

    @Access.Mentor
    @DeleteMapping("{id}")
    public void deleteStudentGroup(@PathVariable Long id) {
        studentGroupService.deleteStudentGroup(id);
    }

}
