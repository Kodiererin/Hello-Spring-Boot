package com.Ujjwal.crudHIBERNATE.Hibernate.dao;

import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Course;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int Id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);


//    One to Many Implementations
    void update(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void saveCourse(Course course);

    Course findCouseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsbyCourseId(int theId);

    Student findStudentAndCouseByStudentId(int theId);

    void updateStudentCourse(Student tempStudent);

    void deleteStudentById(int theId);

}
