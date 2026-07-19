package com.taskflow.AspectOP.Repository;

import com.taskflow.AspectOP.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository{

    public void save(Student student) {
        System.out.println("Studnet created successfully");
    }
}
