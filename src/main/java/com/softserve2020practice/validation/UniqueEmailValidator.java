package com.softserve2020practice.validation;

import com.softserve2020practice.annotations.UniqueEmail;
import com.softserve2020practice.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final AccountRepository accountRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !accountRepository.existsByEmail(email);
    }
}