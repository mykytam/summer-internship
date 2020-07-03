package com.softserve2020practice.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super("Course is already exist!");
    }
}
