package com.work4m.serviceImpl;

import com.work4m.fileUtil.FileWriteReader;
import com.work4m.model.entity.Student;
import com.work4m.service.CommonService;
import com.work4m.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements CommonService<Student>, StudentService {
    @Override
    public Student add(Student entity) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getSurname());
        preparedStatement.setInt(4, entity.getAge());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getPhone());
        preparedStatement.setString(7, entity.getGrade());
        preparedStatement.setString(8, entity.getAddress());
        preparedStatement.executeUpdate();
        return entity;
    }

    @Override
    public Student update(Integer id, Student entity) throws SQLException {
        delete(id);
        add(entity);
        return entity;
    }

    @Override
    public Integer delete(Integer id) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement2 = connection.prepareStatement("select * from students where id=?");
        preparedStatement2.setInt(1, id);
        ResultSet resultSet = preparedStatement2.executeQuery();

        while (resultSet.next()) {
            Integer id1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id1,name, surname, age1, email, phone, grade, adress);
            FileWriteReader.writeFile("textFileDelete",student.toString());
        }

        PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
        preparedStatement.setInt(1, id);
        int deletedId = preparedStatement.executeUpdate();


        return deletedId;
    }

    @Override
    public Student getById(Integer id) throws SQLException{
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students where id = " + id);

        if (resultSet.next()) {
            Integer userId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade, adress);
            return student;
        }else{
            throw new SQLException("Student not found");
        }
    }

    @Override
    public List<Student> getAll() throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname  = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getStudentAgeOlderThan(Integer age) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE age >= ?");
        preparedStatement.setInt(1, age);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age1, email, phone, grade, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getStudentAgeYoungerThan(Integer age) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE age <= ?");
        preparedStatement.setInt(1, age);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age1, email, phone, grade, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getStudentGrade(String grade) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE grade = ?");
        preparedStatement.setString(1, grade);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade1 = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade1, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getStudentGradeLessThan(String grade) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE grade <= ?");
        preparedStatement.setString(1, grade);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade1 = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade1, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getStudentGradeGreaterThan(String grade) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE grade >= ?");
        preparedStatement.setString(1, grade);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade1 = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade1, adress);
            studentList.add(student);
        }
        connection.close();
        return studentList;
    }

    @Override
    public List<Student> getPhoneNumber(String prefiks) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from students where phone like ? ");
        preparedStatement.setString(1, prefiks+"%");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String grade1 = resultSet.getString(7);
            String adress = resultSet.getString(8);

            Student student = new Student(id,name, surname, age, email, phone, grade1, adress);
            studentList.add(student);
        }
        connection.close();

        return studentList;
}}
