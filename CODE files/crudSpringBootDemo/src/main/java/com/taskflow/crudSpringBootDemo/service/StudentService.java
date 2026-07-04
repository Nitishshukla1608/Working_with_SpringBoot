package com.taskflow.crudSpringBootDemo.service;

import com.taskflow.crudSpringBootDemo.entity.Student;
import com.taskflow.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq) {
// perform business logic here
        // then store to DB
        System.out.println("Inside Student Service");
        Student studentResp = studentRepository.save(studentReq);
        System.out.println("Exiting Student Service");
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        else{
            return null;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentsList = studentRepository.findAll();
    return studentsList;
    }



    public Student   updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        else{
            Student studentToSave = existingStudent.get();
            studentToSave.setRollno(studentReq.getRollno());
            studentToSave.setAge(studentReq.getAge());
            studentToSave.setName(studentReq.getName());
            studentToSave.setEmail(studentReq.getEmail());
            studentToSave.setSubject(studentReq.getSubject());

            return studentRepository.save(studentToSave);
        }
    }


    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
