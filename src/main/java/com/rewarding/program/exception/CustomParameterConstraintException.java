package com.rewarding.program.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomParameterConstraintException extends RuntimeException{

    public CustomParameterConstraintException(String message) {
        super(message);
    }
}
