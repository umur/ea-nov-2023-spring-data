package com.example.lab2.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AopIsAwesomeHeaderException extends ResponseStatusException {
    public AopIsAwesomeHeaderException() {
        super(HttpStatus.BAD_REQUEST, "Aop is awesome header is missing");
    }
}
