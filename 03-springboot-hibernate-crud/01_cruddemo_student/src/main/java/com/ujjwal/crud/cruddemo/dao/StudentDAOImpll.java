package com.ujjwal.crud.cruddemo.dao;

import com.ujjwal.crud.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Type;
import java.rmi.server.ExportException;
import java.util.List;


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
        System.out.println("Data Saved");
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class , id);
    }

    @Override
    public List<Student> findAll() {
//        Create Query
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student  ",Student.class);

//        THis will sort in ascending order.
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc ",Student.class);
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc ",Student.class);
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ",Student.class);

//        Return query results
        return theQuery.getResultList();
//
    }

    @Override
    public List<Student> findByLastName(String LastName) {
//        Create query
        TypedQuery<Student> theQuery  = entityManager.createQuery("FROM Student WHERE lastName=:theData" , Student.class);

//        set query params

        theQuery.setParameter("theData",LastName);
//        return query results
        return theQuery.getResultList();
    }

    @Override
    public void update(Student theStudent) {
        System.out.println("Updating the Data");
        try{entityManager.merge(theStudent);}catch (Exception e){
//            I think Merge is deprecated.
            System.out.println(e);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s = entityManager.find(Student.class , id);
        entityManager.remove(s);
    }
}
