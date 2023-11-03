package com.example.lab2.aspect;

import com.example.lab2.entity.ActivityLog;
import com.example.lab2.repository.ActivityLogRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Aspect
@Component
public class AwesomeAspect {

    private final HttpServletRequest request;
    //pointcut for classes in edu.miu.service package to check if POST requests has AOP-IS-AWESOME header. If the header is not present then throw a AopIsAwesomeHeaderException.

    @Before("execution(* com.example.lab2.service.*.*(..))")
    public void checkAopIsAwesomeHeader() throws AopIsAwesomeHeaderException {
        if (request.getHeader("Aop-is-awesome") == null && request.getMethod().equals("POST")) {
            throw new AopIsAwesomeHeaderException();
        }
    }

}
