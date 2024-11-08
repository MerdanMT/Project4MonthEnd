package com.work4m.service;

import com.work4m.model.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    List<Student> getStudentAgeOlderThan(Integer age) throws SQLException;

    List<Student> getStudentAgeYoungerThan(Integer age) throws SQLException;

    List<Student> getStudentGrade(String grade) throws SQLException;

    List<Student> getStudentGradeLessThan(String grade) throws SQLException;

    List<Student> getStudentGradeGreaterThan(String grade) throws SQLException;

    List<Student> getPhoneNumber(String phoneNumber) throws SQLException;
}
