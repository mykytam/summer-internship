package com.softserve2020practice.controllers;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorUpdateDto;
import com.softserve2020practice.models.Mentor;
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

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMentor(@RequestBody MentorCreateDto mentor) {
        mentorService.addMentor(mentor);
    }

    @PutMapping("{id}")
    public void updateMentor(@PathVariable Long id, @RequestBody @Valid MentorUpdateDto mentor) {
        mentorService.updateMentor(id, mentor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
    }
}
