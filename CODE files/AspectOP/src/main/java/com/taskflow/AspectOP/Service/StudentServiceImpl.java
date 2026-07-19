package com.taskflow.AspectOP.Service;

import com.taskflow.AspectOP.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student) {
        System.out.println("student is saved successfully");
    }
}
