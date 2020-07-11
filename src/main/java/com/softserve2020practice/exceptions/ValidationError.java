package com.softserve2020practice.exceptions;

import lombok.Getter;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;

@Getter
public class ValidationError extends ApiError {

    private final Map<String, List<String>> validationErrors;

    public ValidationError(List<FieldError> fieldErrors) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Validation failed");
        this.validationErrors = fieldErrors
                .stream()
                .collect(StreamUtils.toMultiMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}
