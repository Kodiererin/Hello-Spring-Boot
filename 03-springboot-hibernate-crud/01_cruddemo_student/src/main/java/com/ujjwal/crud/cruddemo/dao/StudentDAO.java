package com.ujjwal.crud.cruddemo.dao;
import com.ujjwal.crud.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO   {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String LastName);

    void update(Student student);

    void delete(Integer id);

}