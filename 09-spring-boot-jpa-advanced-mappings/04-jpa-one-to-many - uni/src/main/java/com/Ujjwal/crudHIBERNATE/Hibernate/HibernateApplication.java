package com.Ujjwal.crudHIBERNATE.Hibernate;

import com.Ujjwal.crudHIBERNATE.Hibernate.dao.AppDAO;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Course;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.StandardEmitterMBean;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createCourseAndReviews(appDAO)
		};

	}

	private void createCourseAndReviews(AppDAO appDAO) {
//		Create a Course
//		Add Some Reviews
//		Save the Course

		Course c  = new Course("Pacma  - 1000 Million points");
		c.addReview(new Review("Good Course"));
		c.addReview(new Review("Best Course"));
		c.addReview(new Review("Good Course"));
		c.addReview(new Review("India Course"));

		System.out.println(c);
		System.out.println("Saving the Course");
		System.out.println(c.getReviewList());
		appDAO.saveCourse(c);
		System.out.println("Data Saved");

	}

	private void removeCourseById(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting");

		appDAO.deleteCourseById(id);
		System.out.println("Deleted The Course");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course c = appDAO.findCourseById(theId);

		c.setTitle("Machine Learning and Applied Datascience");
		appDAO.updateCourse(c);

		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

//		Find the Instructor;
		Instructor i = appDAO.findInstructorById(theId);
		System.out.println(i);

//		Update the Instructor
		i.setLastName("Whoisujjwal");
		appDAO.update(i);
		System.out.println("Data Updated");

	}

	private void findInstructotWithCourseJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor ID "+theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor ID");

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);	List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);
		System.out.println(tempInstructor.getCourses());
//		Find Courses for instructor

		System.out.println("Finding Courses for Instructor ID "+theId);

		System.out.println(courses);

		System.out.println("Hp Gaya");
	}


	public void findInstructorWithCourses(AppDAO appDAO){
		int theId = 1;
		System.out.println("Finding the Instructor ID");

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);

		System.out.println(tempInstructor.getCourses());
		System.out.println("Done");
	}
	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Ujjwal" , "Kumar" , "HelloWorld@gmail.com");
//		Instructor instructo  r = new Instructor("India" , "India" , "HelloIndia@gmail.com");

//		Create the instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("www.google.com","Chess");
//		InstructorDetail instructorDetail = new InstructorDetail("www.India.com","Hockey");

		instructor.setInstructorDetail(instructorDetail);
//		Create Some Courses
		Course temoCourse1 = new Course("Machine Learning");
		Course temoCourse2 = new Course("Block Chain");
		Course temoCourse3 = new Course("Prompt Engineering");

		instructor.add(temoCourse1);
		instructor.add(temoCourse2);
		instructor.add(temoCourse3);

//		Save the Instructor
		System.out.println("Saving the Instructor");
		System.out.println(instructor.getCourses());

		appDAO.save(instructor);
		System.out.println("Saved");


	}

	public void deletingInstructorDetailById(AppDAO appDAO){
		int id=2;
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor Detail Is Deleted");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id =1;
		System.out.println(appDAO.findInstructorDetailById(id));
	}

	private void createInstructor(AppDAO appDAO) {
//		Create the Instructor
		Instructor instructor = new Instructor("Ujjwal" , "Kumar" , "HelloWorld@gmail.com");
//		Instructor instructor = new Instructor("India" , "India" , "HelloIndia@gmail.com");

//		Create the instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("www.google.com","Chess");
//		InstructorDetail instructorDetail = new InstructorDetail("www.India.com","Hockey");

//		Associate this Objects
		instructor.setInstructorDetail(instructorDetail);

		System.out.println(instructor);

//		Saving the Instructor
//		Note : This will also save the etails object
//		Because Cascade Type.ALL

		appDAO.save(instructor);

		System.out.println("Done");
	}


	public void findInstrucror(AppDAO appDAO){
		int id=1;
		System.out.println("Finding Instructor By Id ");
		Instructor instructor = new Instructor();
		instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

//	Delete Instructor
	public void deleteInstructor(AppDAO appDAO){
		int id = 1;
		appDAO.deleteInstructorById(id);
	}

}
