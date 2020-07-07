package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorUpdateDto;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.models.Mentor;
import com.softserve2020practice.models.enums.Role;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.repositories.MentorRepository;
import com.softserve2020practice.services.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;
    private final ConversionService conversionService;
    private final CourseRepository courseRepository;

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public void addMentor(MentorCreateDto mentorDto) {

        Mentor mentor = conversionService.convert(mentorDto, Mentor.class);

        List<Course> coursesFromDto = courseRepository.findAllById(mentorDto.getCourses());
        for (Course toAdd : coursesFromDto) {
            mentor.addCourse(toAdd);
        }

        mentor.setRole(Role.MENTOR);
        mentor.setPassword("qwerty");
        mentor.setSalt("123234545");
        mentor.setActive(true);

        mentorRepository.save(mentor);
    }

    @Override
    public void updateMentor(Long id, MentorUpdateDto mentorDto) {

        Mentor toUpdate = mentorRepository.findById(id).orElseThrow(RuntimeException::new);

        toUpdate.setEmail(mentorDto.getEmail());
        toUpdate.setFirstName(mentorDto.getFirstName());
        toUpdate.setLastName(mentorDto.getLastName());
        toUpdate.setPassword(mentorDto.getEmail());

        mentorRepository.save(toUpdate);
    }

    @Override
    public void deleteMentor(Long id) {
        Mentor toDeactivate = mentorRepository.findById(id).orElseThrow(RuntimeException::new);
        toDeactivate.setActive(false);
    }
}
