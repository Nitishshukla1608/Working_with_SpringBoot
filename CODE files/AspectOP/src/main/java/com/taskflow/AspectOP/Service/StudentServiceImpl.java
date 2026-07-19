package com.taskflow.AspectOP.Service;

import com.taskflow.AspectOP.Repository.StudentRepository;
import com.taskflow.AspectOP.dto.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    private  StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void createStudent(Student student) {
studentRepository.save(student);
try{
    Thread.sleep(2000);
}catch(Exception e){
    System.out.println(e.getMessage());
}
    }
}
