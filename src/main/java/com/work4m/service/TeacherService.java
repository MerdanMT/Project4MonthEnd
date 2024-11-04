package com.work4m.service;

import com.work4m.model.entity.Student;
import com.work4m.model.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachersExperienceLessThan(Integer experience) throws SQLException;
    List<Teacher> getTeachersExperienceGreaterThan(Integer experience) throws SQLException;
    List<Teacher> getTeachersDegreesLessThan(Integer degrees) throws SQLException;
    List<Teacher> getTeachersDegreesGreaterThan(Integer degrees) throws SQLException;
    List<Teacher> getTeachersSpeciality(Integer speciality) throws SQLException;
    List<Teacher> getTeachersAgeOlderThan(Integer age) throws SQLException;
    List<Teacher> getTeachersAgeYoungerThan(Integer age) throws SQLException;
    List<Teacher> getPhoneNumber(String phoneNumber) throws SQLException;
}
