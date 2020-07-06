package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Mentor;
import com.softserve2020practice.models.enums.Role;
import com.softserve2020practice.repositories.AccountRepository;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.services.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;

import java.util.List;

@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final AccountRepository accountRepository;
    private final ConversionService conversionService;
    private final CourseRepository courseRepository;

    @Override
    public List<Account> getAllMentors() {
        return accountRepository.findAccountsByRole(Role.MENTOR);
    }

    @Override
    public MentorCreateDto addMentor(MentorCreateDto mentorDto) {

//        if (courseRepository.findAllById(mentorDto.getCourses())) {
//
//        } else {
//
//        }


        courseRepository.findAllById(mentorDto.getCourses());

        Mentor mentor = conversionService.convert(mentorDto, Mentor.class);
        // mentor.setCourses();

        accountRepository.save(mentor);
        return mentorDto;
    }

    @Override
    public Account updateMentor(Long id, String email, String firstName, String lastName, List<Integer> courses, String password) {
        Account mentorToUpdate = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        mentorToUpdate.setEmail(email);
        mentorToUpdate.setFirstName(firstName);
        mentorToUpdate.setLastName(lastName);
        mentorToUpdate.setActive(true);
        mentorToUpdate.setRole(Role.MENTOR);
        mentorToUpdate.setPassword(password);
        accountRepository.save(mentorToUpdate);
        return mentorToUpdate;
    }

    @Override
    public void deleteMentor(Long id) {
        accountRepository.deleteById(id);
    }
}
