package com.taskflow.crudSpringBootDemo.controller;

import com.taskflow.crudSpringBootDemo.dto.CreateStudentRequestDto;
import com.taskflow.crudSpringBootDemo.dto.CreateStudentResponseDto;
import com.taskflow.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import com.taskflow.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import com.taskflow.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// vaidations  -> spring-boot-starter-validation

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto studentRequestDto) {

        CreateStudentResponseDto createdStudent =
                studentService.createStudent(studentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id) {
        CreateStudentResponseDto studentResp = studentService.getStudent(id);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto studentReq) {
        UpdateStudentResponseDto studentResp =
                studentService.updateStudent(id, studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }
}