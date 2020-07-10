package com.softserve2020practice.services.impl;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.dto.MentorResponseDto;
import com.softserve2020practice.dto.MentorUpdateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Course;
import com.softserve2020practice.models.Mentor;
import com.softserve2020practice.models.enums.Role;
import com.softserve2020practice.repositories.CourseRepository;
import com.softserve2020practice.repositories.MentorRepository;
import com.softserve2020practice.services.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.softserve2020practice.services.PasswordUtil.generatePassword;
import static com.softserve2020practice.services.PasswordUtil.generateSalt;
import static com.softserve2020practice.services.PasswordUtil.hashPassword;

@Service
@RequiredArgsConstructor
@Slf4j
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;
    private final ConversionService conversionService;
    private final CourseRepository courseRepository;

    @Override
    public List<MentorResponseDto> getAllMentors() {
        return mentorRepository.findAll().stream()
                .map(mentors -> conversionService.convert(mentors, MentorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addMentor(MentorCreateDto mentorDto) {

        Mentor mentor = conversionService.convert(mentorDto, Mentor.class);
        Account account = mentor.getIdAccount();

        List<Course> coursesFromDto = courseRepository.findAllById(mentorDto.getCourses());
        for (Course toAdd : coursesFromDto) {
            mentor.addCourse(toAdd);
        }

        String password = generatePassword();
        String salt = generateSalt();

        log.info("Generated password: {}", password); // TODO: don't log password! Send it to email

        account.setRole(Role.MENTOR);
        account.setPassword(hashPassword(password, salt));
        account.setSalt(salt);
        account.setActive(true);

        mentorRepository.save(mentor);
    }

    @Override
    public void updateMentor(Long id, MentorUpdateDto mentorDto) {

        Mentor toUpdate = mentorRepository.findById(id).orElseThrow(RuntimeException::new);
        Account account = toUpdate.getIdAccount();

        List<Course> coursesFromDto = courseRepository.findAllById(mentorDto.getCourses());
        for (Course toAdd : coursesFromDto) {
            toUpdate.deleteForUpdate();
            toUpdate.addCourse(toAdd);
        }

        account.setEmail(mentorDto.getEmail());
        account.setFirstName(mentorDto.getFirstName());
        account.setLastName(mentorDto.getLastName());
        account.setPassword(hashPassword(mentorDto.getPassword(), account.getSalt()));

        mentorRepository.save(toUpdate);
    }

    @Override
    public void deleteMentor(Long id) {

        Mentor toDeactivate = mentorRepository.findById(id).orElseThrow(RuntimeException::new);
        Account account = toDeactivate.getIdAccount();
        account.setActive(false);

        mentorRepository.save(toDeactivate);
    }
}
