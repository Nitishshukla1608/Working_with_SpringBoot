package com.taskflow.Aop_Demo.aspect;

import com.taskflow.Aop_Demo.annotations.TrackExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleLoggingAspect {


    //@Before("@annotation()")
    //public void logBeforeMethod(){
    //    System.out.println("Method intercepted");
    //}


 //  @Around("@annotation(com.taskflow.Aop_Demo.annotations.TrackExecutionTime)")
 //   public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
 //long startTime = System.currentTimeMillis();
 //try{
 //    return joinPoint.proceed();
 //}finally {
 //long endTime = System.currentTimeMillis();
 //long executionTime = endTime - startTime;
 //    System.out.println("Time taken by "+joinPoint.getSignature().getName() + ":"  + executionTime + " ms");;
 //}      // This is type passing to pass annotation method


    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint ,
                                       TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();
            }
            long warningThreashold = trackExecutionTime.warnAfter();
            if(executionTime >= warningThreashold){
                System.out.println("SLOW OPERATION ALERT: " +
                        "Time taken by "+operation
                        + ":"  + executionTime + " ms"
                );
            }else{
                System.out.println(
                        "Time taken by "+operation + ":"  + executionTime + " ms");
            }


        }   // This is binding form to pass annotation method



    }
}