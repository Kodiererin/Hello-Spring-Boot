package com.UjjwalSpring.demo.entity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Student {
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentFirstName() {
        return StudentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        StudentFirstName = studentFirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    private int StudentId;

    Student(){

    }
    public Student(int studentId, String studentFirstName, String lastName) {
        StudentId = studentId;
        StudentFirstName = studentFirstName;
        LastName = lastName;
    }

    private String StudentFirstName;
    private String LastName;

}
