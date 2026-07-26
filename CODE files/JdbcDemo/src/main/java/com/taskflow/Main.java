package com.taskflow;

import com.taskflow.model.Student;
import com.taskflow.repository.StudentRepository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

       StudentRepository studentRepository = new StudentRepository();
//studentRepository.updateStudent(new Student("Rohit shukla" ,"rohit35@gmail.com" ,55),3L);

        studentRepository.getStudentById(3L);
}
}
