package com.taskflow.filters.service;


import com.taskflow.filters.dto.Student;
import com.taskflow.filters.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");
        return studentResponseDto;
    }


}
