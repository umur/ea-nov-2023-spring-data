package com.miu.edu.student.negi.Lab3.aspects;

import com.miu.edu.student.negi.Lab3.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralAspect {

  //  @Pointcut("execution(* com.miu.edu.student.negi.Lab3.controller.*.*(..))")
   // @Pointcut("within( com.miu.edu.student.negi.Lab3..*)")
   // @Pointcut("this(com.miu.edu.student.negi.Lab3.service.ProductService)")
//    @Pointcut("@annotation(com.miu.edu.student.negi.Lab3.aspects.CustomAnnotation)")
//    public void loggingPointCut(){}
//   @Before("loggingPointCut()")
//    public void before(JoinPoint joinpoint){
//        log.info("Before method invoked::"+joinpoint.getSignature());
//}
//     @After("loggingPointCut()")

    // public void after(JoinPoint joinpoint){
    //   log.info("After method invoked::"+joinpoint.getSignature());
    // }

    @AfterReturning(value = "execution(* com.miu.edu.student.negi.Lab3.controller.*.*(..))",
            returning = "product")
    public void after(JoinPoint joinpoint, Product product) {
        log.info("After method invoked::" + product);

    }
    @AfterThrowing(value = "execution(* com.miu.edu.student.negi.Lab3.controller.*.*(..))", throwing = "e")

    public void after(JoinPoint joinpoint, Exception e) {
        log.info("After method invoked::" + e.getMessage());
    }

//    @Around("execution(* com.miu.edu.student.negi.Lab3.controller.*.*(..))")
//    public Object around (ProceedingJoinPoint joinPoint)throws Throwable{
//        log.info("Before method invoked::"+joinPoint.getSignature());
//        Object object=joinPoint.proceed();
//        if(object instanceof Product){
//            log.info("After method invoked..."+joinPoint.getArgs()[0]);
//        }else if(object instanceof Category){
//            log.info("After method invoked..."+joinPoint.getArgs()[0]);
//        }return  object;
//    }


}