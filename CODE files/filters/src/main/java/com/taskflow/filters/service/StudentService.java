package com.taskflow.filters.service;


import com.taskflow.filters.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student) {
        System.out.println("student created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
        System.out.println(student.getId());

        //try{
        //    Thread.sleep(2000);
        //} catch (InterruptedException e) {
        //
        //}
    }


}
