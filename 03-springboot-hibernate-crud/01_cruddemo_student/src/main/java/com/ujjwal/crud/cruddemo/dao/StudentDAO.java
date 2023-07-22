package com.ujjwal.crud.cruddemo.dao;
import com.ujjwal.crud.cruddemo.entity.Student;

public interface StudentDAO   {
    void save(Student student);
    Student findById(Integer id);
}