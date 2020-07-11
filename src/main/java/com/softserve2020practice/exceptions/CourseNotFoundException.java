package com.softserve2020practice.exceptions;

import javax.persistence.EntityNotFoundException;

public class CourseNotFoundException extends EntityNotFoundException {

    public CourseNotFoundException(String message) {
        super(message);
    }

}
