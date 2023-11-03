package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AopIsAwesomeHeaderException extends ResponseStatusException {

    public AopIsAwesomeHeaderException() {
        super(HttpStatus.BAD_REQUEST, "AopIsAwesomeHeaderException");
    }

}
