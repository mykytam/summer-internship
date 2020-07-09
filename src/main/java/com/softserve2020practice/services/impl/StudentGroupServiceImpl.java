package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.StudentGroupRequestDto;
import com.softserve2020practice.dto.StudentGroupResponseDto;
import com.softserve2020practice.exceptions.CourseNotFoundException;
import com.softserve2020practice.exceptions.StudentGroupNotFoundException;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.models.Mentor;
import com.softserve2020practice.models.Student;
import com.softserve2020practice.models.StudentGroup;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.repositories.StudentGroupRepository;
import com.softserve2020practice.repositories.StudentRepository;
import com.softserve2020practice.services.StudentGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGroupServiceImpl implements StudentGroupService {

    private final ConversionService conversionService;
    private final StudentGroupRepository studentGroupRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public StudentGroupResponseDto createStudentGroup(StudentGroupRequestDto studentGroupRequestDto) {

        StudentGroup studentGroup =
                conversionService.convert(studentGroupRequestDto, StudentGroup.class);

        Course course = courseRepository.findById(studentGroupRequestDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Course group not found!"));

        studentGroup.setCourse(course);

        List<Student> allById = studentRepository.findAllById(studentGroupRequestDto.getStudentId());
        studentGroup.setStudents(allById);

        StudentGroup savedStudentGroup = studentGroupRepository.save(studentGroup);

        return conversionService.convert(savedStudentGroup, StudentGroupResponseDto.class);
    }

    @Override
    public List<StudentGroupResponseDto> findAllStudentGroups() {
        return studentGroupRepository.findAll()
                .stream()
                .map(studentGroup -> conversionService.convert(studentGroup, StudentGroupResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentGroupResponseDto findStudentGroupById(Long id) {
        StudentGroup studentGroup = studentGroupRepository.findById(id)
                .orElseThrow(() -> new StudentGroupNotFoundException("Student group not found!"));

        StudentGroupResponseDto studentGroupResponseDto = new StudentGroupResponseDto();
        studentGroupResponseDto.setMentorIds(studentGroup.getMentors()
                .stream()
                .map(Mentor::getId)
                .collect(Collectors.toList()));

        return conversionService.convert(studentGroup, studentGroupResponseDto.getClass());
    }

    @Override
    public StudentGroupResponseDto updateStudentGroup(StudentGroupRequestDto studentGroupRequestDto, Long id) {
        StudentGroup studentGroup = studentGroupRepository.findById(id)
                .orElseThrow(() -> new StudentGroupNotFoundException("Student group not found!"));

        Course course = courseRepository.findById(studentGroupRequestDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Course group not found!"));

        studentGroup.setCourse(course);
        studentGroup.setName(studentGroupRequestDto.getName());
        studentGroup.setStartDate(studentGroupRequestDto.getStartDate());
        studentGroup.setFinishDate(studentGroupRequestDto.getFinishDate());

        List<Student> allById = studentRepository.findAllById(studentGroupRequestDto.getStudentId());
        studentGroup.setStudents(allById);

        StudentGroup savedStudentGroup =
                studentGroupRepository.save(studentGroup);

        return conversionService.convert(savedStudentGroup, StudentGroupResponseDto.class);
    }

    @Override
    public void deleteStudentGroup(Long id) {
        studentGroupRepository.deleteById(id);
    }
}
