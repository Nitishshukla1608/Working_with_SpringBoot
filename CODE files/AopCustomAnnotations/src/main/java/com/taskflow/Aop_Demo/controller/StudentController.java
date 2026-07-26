package com.taskflow.Aop_Demo.controller;

import com.taskflow.Aop_Demo.dto.Student;
import com.taskflow.Aop_Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Student> cretateStudent(@RequestBody Student student){
       return   ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<String>getStudent(){
        return   ResponseEntity.ok(studentService.getStudent("All student data"));
    }

}
