package com.softserve2020practice.services;

import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.models.StudentGroup;

import java.util.List;

public interface StudentGroupService {

    StudentGroupResponseDto createStudentGroup(StudentGroupRequestDto studentGroup);

    List<StudentGroup> findAllStudentGroups();

    StudentGroupResponseDto findStudentGroupById(Long id);

    StudentGroupResponseDto updateStudentGroup(StudentGroupRequestDto studentGroup, Long id);

    void deleteStudentGroup(Long id);

}
