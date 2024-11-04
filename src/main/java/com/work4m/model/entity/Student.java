package com.work4m.model.entity;

public class Student extends Person {
    private String grade;
    private String address;

    public Student() {
    }

    public Student(String grade, String address) {
        this.grade = grade;
        this.address = address;
    }

    public Student(Integer id, String name, String surname, Integer age, String email, String phone, String grade, String address) {
        super(id, name, surname, age, email, phone);
        this.grade = grade;
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+
                "grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                "} ";
    }
}
