package com.example.lab2.aspect;

import com.example.lab2.entity.ActivityLog;
import com.example.lab2.repository.ActivityLogRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggerAspect {

    private final ActivityLogRepo activityLogRepo;

    @Around("@annotation(com.example.lab2.aspect.ExecutionTime)")
    public Object log(ProceedingJoinPoint pcp) throws Throwable {
        long begin = System.currentTimeMillis();
        var result = pcp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Method is : " +(end-begin));
        var activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(pcp.getSignature().getName());
        activityLog.setDuration(end-begin);
        activityLogRepo.save(activityLog);
        return result;
    }
}
