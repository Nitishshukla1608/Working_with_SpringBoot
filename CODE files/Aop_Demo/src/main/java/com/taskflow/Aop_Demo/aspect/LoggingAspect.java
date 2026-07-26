package com.taskflow.Aop_Demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    //
    //@Before("execution(String com.taskflow.Aop_Demo.service.StudentService.createStudent(..))")
    //public void logBeforeMethod(JoinPoint joinPoint) {
    //    Object[] arr = joinPoint.getArgs();
    //    System.out.println("Student is going to be saved...");
    //}

    //@AfterReturning(
    //        value = "execution(* com.taskflow.Aop_Demo.service.StudentService.createStudent(..))",
    //         returning = "result"
    //)
    //public void logAfterReturningMethod(String result) {
    //    System.out.println("Target method returned: "+result);
    //
    //}

    
    //
    //@AfterThrowing(
    //        value = "execution(* com.taskflow.Aop_Demo.service.StudentService.createStudent(..))",
    //        throwing = "exception"
    //)
    //public void logAfterThrowingMethod(Throwable exception) {
    //    System.out.println("Exceptiion type "+exception.getClass().getName());
    //    System.out.println("Exceptiion message "+exception.getMessage());
    //}


    //
    //@After(
    //        value = "execution(* com.taskflow.Aop_Demo.service.StudentService.createStudent(..))"
    //)
    //public void logAfterMethod() {
    //    System.out.println("LogAfterMethod executed");
    //}



    @Around(
            value = "execution(* com.taskflow.Aop_Demo.service.StudentService.createStudent(..))"
    )
    public String logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before target method...");
       String message = (String) joinPoint.proceed();
        System.out.println("After target method...");
        return message;
    }


}