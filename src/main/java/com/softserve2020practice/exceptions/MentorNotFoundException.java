package com.softserve2020practice.exceptions;

import javax.persistence.EntityNotFoundException;

public class MentorNotFoundException extends EntityNotFoundException {
    public MentorNotFoundException(String message) {
        super(message);
    }
}
