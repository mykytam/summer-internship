package com.softserve2020practice.exeptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super("Course is already exist!");
    }
}
