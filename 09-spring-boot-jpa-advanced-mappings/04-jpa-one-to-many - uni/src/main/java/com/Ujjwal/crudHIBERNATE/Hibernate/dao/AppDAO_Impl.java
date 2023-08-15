package com.Ujjwal.crudHIBERNATE.Hibernate.dao;

import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Course;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
//       entityManager.remove(instructor);


//        Modified Code for new Implemention of deletion to resolve errors.

//        Get the course.
//        Break the association of courses instructor
        List<Course> tempCourses = instructor.getCourses();

        for(Course iterateCourses: tempCourses){
            iterateCourses.setInstructor(null);
        }

        entityManager.remove(instructor);

//     This code will first remove instructor from the course and then it will rmeove the instructor.
//        This way we will prevent deleting the whole course.



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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
//        Create Queey
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data" , Course.class
        );

        query.setParameter("data",theId);
//        Execute the queey
        List<Course> courses = query.getResultList();
        return  courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
//        Create Query
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN  fetch i.courses join fetch i.instructorDetail  where  i.id =:data " , Instructor.class);

        query.setParameter("data" , theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId){
        return entityManager.find(Course.class , theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
//        retrieve the course
//        Delete the course.

        Course theCourse = entityManager.find(Course.class , theId);

        entityManager.remove(theCourse);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
//        This will save the Course and the Reviews.
    }

    @Override
    public Course findCouseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join  fetch c.reviewList where c.id = :data" , Course.class);
        query.setParameter("data" , theId);

        Course c = query.getSingleResult();
        return c;
    }

    @Override
    public Course findCourseAndStudentsbyCourseId(int theId) {
//        Create query
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join  fetch c.students where c.id  = :data" , Course.class);
        query.setParameter("data" , theId);

//        Execute the query

        Course c = query.getSingleResult();
        return c;
    }

    @Override
    public Student findStudentAndCouseByStudentId(int theId) {
        System.out.println("Finding The Student");
        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student s JOIN  FETCH s.courses where s.id  = :data" , Student.class);
        query.setParameter("data" , theId);

        Student s = query.getSingleResult();
        return  s;
    }

    @Override
    @Transactional
    public void updateStudentCourse(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student s = entityManager.find(Student.class , theId);
        System.out.println(s);
        entityManager.remove(s);
    }

}
