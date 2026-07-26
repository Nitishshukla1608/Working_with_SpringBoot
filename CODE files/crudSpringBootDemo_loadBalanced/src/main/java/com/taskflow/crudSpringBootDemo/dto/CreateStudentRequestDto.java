package com.taskflow.crudSpringBootDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateStudentRequestDto {

    @NotBlank(message = "Name cannot be null, empty or blank")
    @Size(min = 2, max = 50, message = "Student name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be at least 18 years old")
    private Integer age;

    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email must be valid")
    private String email;

    @NotNull(message = "RollNo is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;

    // Getters

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getSubject() {
        return subject;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}