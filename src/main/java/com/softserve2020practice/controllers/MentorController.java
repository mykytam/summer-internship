package com.softserve2020practice.controllers;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.services.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mentors")
public class MentorController {

    private final MentorService mentorService;

    @GetMapping
    public List<Account> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MentorCreateDto createMentor(String email, String firstName, String lastName, Set<Integer> courses) {
        return mentorService.addMentor(email, firstName, lastName, courses);
    }

    @PutMapping("{id}")
    public Account updateMentor(@PathVariable Long id, String email, String firstName, String lastName, List<Integer> courses, String password) {
        return mentorService.updateMentor(id, email, firstName, lastName, courses, password);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
    }
}
