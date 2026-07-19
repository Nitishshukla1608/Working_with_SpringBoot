package com.taskflow.AspectOP.Service;

public class LoggingServiceUtil {

    public void logStart(String className , String methodName){
        System.out.println("Starting " + className + "." + methodName);
    }


    public void logEnd(String className , String methodName){
        System.out.println("Ending " + className + "." + methodName);
    }

}
