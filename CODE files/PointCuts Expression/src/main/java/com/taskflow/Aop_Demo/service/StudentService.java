package com.taskflow.Aop_Demo.service;

import com.taskflow.Aop_Demo.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Timestamp
    public Student createStudent(Student student){
        System.out.println("Student saved");
    return student;
    }


    public String getStudent(String s){
        System.out.println("All student data ...");
        return s;
    }

    public int dummyMethod(){
        return 0;
    }

}
