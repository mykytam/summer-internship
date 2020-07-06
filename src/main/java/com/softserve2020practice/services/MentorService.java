package com.softserve2020practice.services;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.models.Account;

import java.util.List;

public interface MentorService {

    List<Account> getAllMentors();

    MentorCreateDto addMentor(MentorCreateDto mentorDto);

    Account updateMentor(Long id, String email, String firstName, String lastName, List<Integer> courses, String password);

    void deleteMentor(Long id);
}
