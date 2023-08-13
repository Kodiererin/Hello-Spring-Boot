package com.Ujjwal.crudHIBERNATE.Hibernate.dao;

import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int Id);

    void deleteInstructorDetailById(int id);
}
