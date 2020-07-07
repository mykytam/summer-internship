package com.softserve2020practice.services;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorUpdateDto;
import com.softserve2020practice.models.Mentor;

import java.util.List;

public interface MentorService {

    List<Mentor> getAllMentors();

    void addMentor(MentorCreateDto mentorDto);

    void updateMentor(Long id, MentorUpdateDto mentorDto);

    void deleteMentor(Long id);
}
