package com.taskflow.Aop_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.taskflow.Aop_Demo.service.StudentService.createStudent())")
    public void logBeforeMethod() {
        System.out.println("Student is going to be saved...");
    }
}