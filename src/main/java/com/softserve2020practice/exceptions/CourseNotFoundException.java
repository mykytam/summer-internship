package com.softserve2020practice.exceptions;

public class CourseNotFoundException extends EntityNotFoundException {

    public CourseNotFoundException(String message) {
        super(message);
    }

}
