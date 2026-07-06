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
studentReq.setDeleted(false);
        // then store to DB
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        else{
            return null;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentsList = studentRepository.findByDeletedIsFalse();
    return studentsList;
    }



    public Student   updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
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
studentToSave.setDeleted(false);
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

    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        else{
           Student studentToSoftDelete = existingStudent.get();
            studentToSoftDelete.setDeleted(true);
            studentRepository.save(studentToSoftDelete);
            return true;
        }
    }
}
