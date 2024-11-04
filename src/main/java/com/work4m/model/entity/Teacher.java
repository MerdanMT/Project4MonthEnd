package com.work4m.model.entity;

public class Teacher extends Person {
    private Integer experience;
    private String degrees;
    private String specialty;

    public Teacher() {
    }

    public Teacher(Integer experience, String degrees, String specialty) {
        this.experience = experience;
        this.degrees = degrees;
        this.specialty = specialty;
    }

    public Teacher(Integer id, String name, String surname, Integer age, String email, String phone, Integer experience, String degrees, String specialty) {
        super(id, name, surname, age, email, phone);
        this.experience = experience;
        this.degrees = degrees;
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Teacher{" +
                "experience='" + experience + '\'' +
                ", degrees='" + degrees + '\'' +
                ", specialty='" + specialty + '\'' +
                "} ";
    }
}
