package com.example.demo.aspect;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Aspect
@Component
public class ExecutionTimeAspect {

    final ActivityLogRepository activityLogRepository;


    @Around("@annotation(com.example.demo.aspect.annotaions.ExecutionTime)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        var activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setDuration((int) (end - start));
        activityLog.setOperation(joinPoint.getSignature().getName());
        activityLogRepository.save(activityLog);

        return proceed;
    }

}
