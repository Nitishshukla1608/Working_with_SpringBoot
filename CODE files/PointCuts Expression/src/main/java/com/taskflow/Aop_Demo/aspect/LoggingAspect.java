package com.taskflow.Aop_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // ==========================================================
    // execution() Designator Examples
    // ==========================================================

    // @Before("execution(* com.taskflow.Aop_Demo.service.StudentService.*(..))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches every method of StudentService with any number of parameters.


    // @Before("execution(* com.taskflow.Aop_Demo.service..*(..))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches every method in every class inside the service package and its subpackages.


    // @Before("execution(* com.taskflow.Aop_Demo.service.StudentService.*(*))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods having exactly one parameter.


    // @Before("execution(* com.taskflow.Aop_Demo.service.StudentService.get*(..))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods whose names start with "get".


    // @Before("execution(* com.taskflow.Aop_Demo.service.*.*(*))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches any method with one parameter in any class of the service package.


    // @Before("execution(* *(..))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Avoid using this because it intercepts almost every method, including Spring internals.


    // @Before("execution(* com.taskflow.Aop_Demo..*(..))")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches every method inside com.taskflow.Aop_Demo and all its subpackages.


    // @Before(
    //     "execution(public com.taskflow.Aop_Demo.dto.Student " +
    //     "com.taskflow.Aop_Demo.service.StudentService.createStudent(" +
    //     "com.taskflow.Aop_Demo.dto.Student))"
    // )
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches one specific method.


    // ==========================================================
    // within() Designator
    // ==========================================================

    // @Before("within(com.taskflow.Aop_Demo.service..*)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches every method inside every class of the service package.


    // ==========================================================
    // @annotation Designator
    // ==========================================================

    // @Before("@annotation(jdk.jfr.Timestamp)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods annotated with @Timestamp.


    // ==========================================================
    // bean() Designator
    // ==========================================================

    // @Before("bean(studentService)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches the bean named "studentService".


    // @Before("bean(studentService) || bean(studentController)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches both beans.


    // ==========================================================
    // Pointcut Example
    // ==========================================================

    // @Pointcut(
    //     "within(com.taskflow.Aop_Demo.service..*) && execution(public * *(..))"
    // )
    // public void logPublicServiceMethod() {
    // }
    // Matches all public methods inside the service package.


    // ==========================================================
    // @within Designator
    // ==========================================================

    // @Before("@within(org.springframework.stereotype.Service)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods of classes annotated with @Service.


    // ==========================================================
    // args() Designator
    // ==========================================================

    // @Before(
    //     "args(com.taskflow.Aop_Demo.dto.Student) && " +
    //     "within(com.taskflow.Aop_Demo.service..*)"
    // )
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods whose runtime argument is Student.


    // ==========================================================
    // @args Designator
    // ==========================================================

    // @Before(
    //     "@args(jdk.jfr.Timestamp) && " +
    //     "within(com.taskflow.Aop_Demo.service..*)"
    // )
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted");
    // }
    // Matches methods whose argument's class is annotated with @Timestamp.


    // ==========================================================
    // Reusable Pointcut
    // ==========================================================

    @Before("com.taskflow.Aop_Demo.aspect.ApplicationPointcuts.publicServiceMethod()")
    public void logBeforeMethod() {
        System.out.println("Method Intercepted");
    }

}