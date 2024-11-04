package com.work4m;

import com.work4m.model.entity.Student;
import com.work4m.serviceImpl.StudentServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentServiceImpl studentService = new StudentServiceImpl();
        System.out.println(studentService.delete(15));
    }
}