package com.taskflow.repository;

import com.taskflow.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/student_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "16082001@Raj";

    Connection connection;
PreparedStatement preparedStatement;
    //public void createStudent(Student student) {
    //    try (
    //            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    //            Statement statement = connection.createStatement()
    //    ) {
    //        //String sql = "INSERT INTO students(name, email, age) VALUES('Aditya', 'adi@gmail.com', 78)";
    //        String sql = """
    //                         insert into  students(name ,email ,age)
    //                         values('%s','%s','%d')"""
    //                .formatted(student.getName() , student.getEmail(), student.getAge());  // using text Block
    //
    //        int rowsAffected = statement.executeUpdate(sql);
    //        if (rowsAffected > 0) {
    //            System.out.println("Create operation successful.");
    //        } else {
    //            System.out.println("Creation failed.");
    //        }
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //}



    public void createStudent(Student student) throws SQLException {
        String sql = """
                    insert into students(name,email,age) values(?,?,?)
                    """;
        try(
                Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected == 1){
                System.out.println("Student created successfully");
            }else{
                System.out.println("Failed to create student");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







    public void updateStudent(Student student, Long id) throws SQLException {
        String sql = """
            update students set name=?,email=?,age=? where id=?    
                """;
        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {

preparedStatement.setString(1,student.getName());
preparedStatement.setString(2,student.getEmail());
preparedStatement.setInt(3,student.getAge());
preparedStatement.setLong(4,id);
            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Update operation successful.");
            } else {
                System.out.println("updation failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public void deleteStudent(Long id){
        String sql = """
            delete from students  where id=?    
            """;
        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
         preparedStatement.setLong(1,id);
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Delete operation successful.");
            } else {
                System.out.println("Deletion failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void getStudentById(Long id){
        String sql = """
select id,name,email,age from students where id = ?""";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1,id);
            try( ResultSet resultSet = preparedStatement.executeQuery()){
              if(  resultSet.next()) {
                  Student student = mapRow(resultSet);
                  System.out.println(student);
              }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public void getStudents(){
        String sql = """
select id,name,email,age from students """;

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            try( ResultSet resultSet = preparedStatement.executeQuery()){
                List<Student> studentList = new ArrayList<>();
                while(  resultSet.next()) {
                    Student student = mapRow(resultSet);
                  studentList.add(student);
                }
                System.out.println(studentList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }

}