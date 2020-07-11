package com.softserve2020practice.exceptions;

import javax.persistence.EntityNotFoundException;

public class StudentGroupNotFoundException extends EntityNotFoundException {

    public StudentGroupNotFoundException(String message) {
        super(message);
    }

}
