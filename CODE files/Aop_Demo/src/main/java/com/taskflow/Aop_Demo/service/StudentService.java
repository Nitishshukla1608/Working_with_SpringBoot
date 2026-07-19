package com.taskflow.Aop_Demo.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String createStudent(){

        System.out.println("Student saved");
        return "Student saved";
    }

}
