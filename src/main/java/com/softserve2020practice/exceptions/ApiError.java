package com.softserve2020practice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
public class ApiError {

    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(HttpStatus httpStatus, String message) {
        this(httpStatus, message, LocalDateTime.now());
    }

}
