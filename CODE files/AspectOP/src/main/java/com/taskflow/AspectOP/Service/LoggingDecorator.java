package com.taskflow.AspectOP.Service;

import com.taskflow.AspectOP.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    LoggingServiceUtil loggingServiceUtil = new LoggingServiceUtil();
    @Override
    public void createStudent(Student student) {
        loggingServiceUtil.logStart("StudentServiceImpl", "createStudent");
        studentServiceImpl.createStudent(student);
        loggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
    }
}
