package com.work4m.serviceImpl;

import com.work4m.model.entity.Student;
import com.work4m.model.entity.Teacher;
import com.work4m.service.CommonService;
import com.work4m.service.TeacherService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements CommonService<Teacher>, TeacherService {

    @Override
    public Teacher add(Teacher entity) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getSurname());
        preparedStatement.setInt(4, entity.getAge());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getPhone());
        preparedStatement.setInt(7, entity.getExperience());
        preparedStatement.setString(8, entity.getDegrees());
        preparedStatement.setString(9, entity.getSpecialty());

        preparedStatement.executeUpdate();
        connection.close();
        return entity;
    }

    @Override
    public Teacher update(Integer id, Teacher entity) throws SQLException {
        delete(id);
        add(entity);
        return entity;
    }

    @Override
    public Integer delete(Integer id) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement = connection.prepareStatement("delete from teacher where id=?");
        preparedStatement.setInt(1, id);
        int deletedId = preparedStatement.executeUpdate();
        connection.close();
        return deletedId;
    }

    @Override
    public Teacher getById(Integer id) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher where id = " + id);

        if (resultSet.next()) {
            Integer userId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience = resultSet.getInt(7);
            String degrees = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id,name, surname, age, email, phone, experience, degrees,specialty);
            connection.close();
            return teacher;
        }else{
            throw new SQLException("Student not found");
        }

    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher");

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname  = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience = resultSet.getInt(7);
            String degrees = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id,name, surname, age, email, phone, experience, degrees,specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersExperienceLessThan(Integer experience) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE experience <= ?");
        preparedStatement.setInt(1, experience);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age, email, phone, experience1, degrees, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersExperienceGreaterThan(Integer experience) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE experience >= ?");
        preparedStatement.setInt(1, experience);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age, email, phone, experience1, degrees, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersDegreesLessThan(Integer degrees) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE degrees <= ?");
        preparedStatement.setInt(1, degrees);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersDegreesGreaterThan(Integer degrees) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE degrees >= ?");
        preparedStatement.setInt(1, degrees);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersSpeciality(Integer speciality) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE speciality = ?");
        preparedStatement.setInt(1, speciality);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age1, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersAgeOlderThan(Integer age) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE age >= ?");
        preparedStatement.setInt(1, age);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age1, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getTeachersAgeYoungerThan(Integer age) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE age <= ?");
        preparedStatement.setInt(1, age);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age1 = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age1, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

    @Override
    public List<Teacher> getPhoneNumber(String prefiks) throws SQLException {
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/school","postgres","MerdanMT68");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher where phone like ? ");
        preparedStatement.setString(1, prefiks+"%");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Teacher> teacherList = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            String email = resultSet.getString(5);
            String phone = resultSet.getString(6);
            Integer experience1 = resultSet.getInt(7);
            String degrees1 = resultSet.getString(8);
            String specialty = resultSet.getString(9);

            Teacher teacher = new Teacher(id, name, surname, age, email, phone, experience1, degrees1, specialty);
            teacherList.add(teacher);
        }
        connection.close();
        return teacherList;
    }

}
