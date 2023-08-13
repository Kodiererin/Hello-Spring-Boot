package com.Ujjwal.crudHIBERNATE.Hibernate.dao;

import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class AppDAO_Impl implements AppDAO{

//    Define Field for Entity Manager
    private EntityManager entityManager;


    @Autowired
    public AppDAO_Impl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

//    Inject Entity Manager using Constructor Injection


    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class , theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
//        entityManager.remove(theId);

        Instructor instructor = entityManager.find(Instructor.class , theId);
//      remove the associated Object Reference

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int Id) {
        InstructorDetail instructorDetail = new InstructorDetail();

        instructorDetail = entityManager.find(InstructorDetail.class , Id);
//        Break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
//        Find the InstructorDetail
        InstructorDetail instructorDetail =  new InstructorDetail();
        instructorDetail = entityManager.find(InstructorDetail.class , id);

        System.out.println(instructorDetail);
        entityManager.remove(instructorDetail);
        System.out.println("File Deleted");
    }


}
