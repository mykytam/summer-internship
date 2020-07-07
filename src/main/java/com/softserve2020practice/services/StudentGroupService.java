package com.softserve2020practice.services;

import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.dto.StudentGroupResponseDto;

import java.util.List;

public interface StudentGroupService {

    StudentGroupResponseDto createStudentGroup(StudentGroupRequestDto studentGroup);

    List<StudentGroupResponseDto> findAllStudentGroups();

    StudentGroupResponseDto findStudentGroupById(Long id);

    StudentGroupResponseDto updateStudentGroup(StudentGroupRequestDto studentGroup, Long id);

    void deleteStudentGroup(Long id);

}
