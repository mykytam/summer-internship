package com.softserve2020practice.exeptions;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException() {
        super("Not found course!");
    }
}
