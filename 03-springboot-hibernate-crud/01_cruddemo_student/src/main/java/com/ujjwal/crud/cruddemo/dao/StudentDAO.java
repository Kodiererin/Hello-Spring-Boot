package com.ujjwal.crud.cruddemo.dao;
import com.ujjwal.crud.cruddemo.entity.Student;

public interface StudentDAO   {
    default void save(Student student){

    }
}