package com.softserve2020practice.exceptions;

import javax.persistence.EntityNotFoundException;

public class StudentNotFoundException extends EntityNotFoundException {

    public StudentNotFoundException(String message) {
        super(message);
    }

}
