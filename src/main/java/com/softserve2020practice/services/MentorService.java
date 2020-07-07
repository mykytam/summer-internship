package com.softserve2020practice.services;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorResponseDto;
import com.softserve2020practice.dto.MentorUpdateDto;

import java.util.List;

public interface MentorService {

    List<MentorResponseDto> getAllMentors();

    void addMentor(MentorCreateDto mentorDto);

    void updateMentor(Long id, MentorUpdateDto mentorDto);

    void deleteMentor(Long id);
}
