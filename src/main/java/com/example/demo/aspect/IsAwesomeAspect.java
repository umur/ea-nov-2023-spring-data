package com.example.demo.aspect;

import com.example.demo.exceptions.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class IsAwesomeAspect {

    private final HttpServletRequest request;

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void checkHeader() {
        if (request.getHeader("AOP-IS-AWESOME") == null && request.getMethod().equals("POST")) {
            throw new AopIsAwesomeHeaderException();
        }
    }

}
