package com.taskflow.crudSpringBootDemo.repository;
// yahan par hamaari student.java class ek SQL query me convert ho jaayegii by using spring  JPA

import com.taskflow.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();
    Boolean existsByEmail(String emailId);
}
