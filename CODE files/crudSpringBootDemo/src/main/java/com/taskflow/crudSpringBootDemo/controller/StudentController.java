package com.taskflow.crudSpringBootDemo.controller;


import com.taskflow.crudSpringBootDemo.entity.Student;
import com.taskflow.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

private StudentService studentService;
public StudentController(StudentService studentService) {
    this.studentService = studentService;  // always prefer constructor injection
}




    @PostMapping("/create")

    public ResponseEntity<Student> createStudent(@RequestBody Student student){
Student createdStudent = studentService.createStudent(student);
return ResponseEntity.ok(createdStudent);
    }




    // read one student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
  Student studentResp  =  studentService.getStudent(id);
  if(studentResp == null){
      return  ResponseEntity.notFound().build();
  }
  return ResponseEntity.ok(studentResp);
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student> studentsList = studentService.getAllStudents();

        if (studentsList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentsList);
    }



    // update one student
    @PutMapping ("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student studentReq){
        Student studentResp  =  studentService.updateStudent(id,studentReq);
        if(studentResp == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    // Delete one student
    @DeleteMapping ("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted  =  studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-softly")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
    Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted Softly");
    }



}
