package com.softserve2020practice.controllers;

import com.softserve2020practice.annotations.Access;
import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorResponseDto;
import com.softserve2020practice.dto.MentorUpdateDto;
import com.softserve2020practice.services.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/mentors")
@RestController
@RequiredArgsConstructor
public class MentorController {

    private final MentorService mentorService;

    @Access.AdminAndMentor
    @GetMapping
    public List<MentorResponseDto> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @Access.Admin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMentor(@RequestBody @Valid MentorCreateDto mentor) {
        mentorService.addMentor(mentor);
    }

    @Access.AdminAndMentor
    @PutMapping("{id}")
    public void updateMentor(@PathVariable Long id, @RequestBody @Valid MentorUpdateDto mentor) {
        mentorService.updateMentor(id, mentor);
    }

    @Access.Admin
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
    }
}
