package com.softserve2020practice.exceptions;

public class NotFoundIdException extends RuntimeException {

    public NotFoundIdException() {
        super("Not found course!");
    }

}
