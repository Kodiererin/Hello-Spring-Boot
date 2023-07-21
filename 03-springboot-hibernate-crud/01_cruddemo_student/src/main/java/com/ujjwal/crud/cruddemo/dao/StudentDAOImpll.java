package com.ujjwal.crud.cruddemo.dao;

import com.ujjwal.crud.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;


@Repository
public class StudentDAOImpll implements StudentDAO   {
//      Define field for entity manager
    private EntityManager entityManager;



//    inject entity manager using constructor injection


    @Autowired
    public StudentDAOImpll(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save method
    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }
}
