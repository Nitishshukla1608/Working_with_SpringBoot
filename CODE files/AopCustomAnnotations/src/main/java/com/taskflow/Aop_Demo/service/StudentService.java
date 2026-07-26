package com.taskflow.Aop_Demo.service;

import com.taskflow.Aop_Demo.annotations.TrackExecutionTime;
import com.taskflow.Aop_Demo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creates new student"
    )
    public Student createStudent(Student student){
        System.out.println("Student saved");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

@TrackExecutionTime(
        warnAfter = 1500,
        operation = "Get student data"
)
    public String getStudent(String s){
        System.out.println(s);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    return s;
    }

}
