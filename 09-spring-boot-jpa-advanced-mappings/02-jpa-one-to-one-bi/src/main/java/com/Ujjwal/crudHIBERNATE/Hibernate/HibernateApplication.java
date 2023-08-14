package com.Ujjwal.crudHIBERNATE.Hibernate;

import com.Ujjwal.crudHIBERNATE.Hibernate.dao.AppDAO;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.Instructor;
import com.Ujjwal.crudHIBERNATE.Hibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.StandardEmitterMBean;
import java.util.Objects;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{

//			This was for the Creation
			createInstructor(appDAO);

//			This is for Finding
//			findInstrucror(appDAO);

//			For Deletion
//			deleteInstructor(appDAO);

//			For finding InstructoDetail By Id.
//			findInstructorDetailById(appDAO);

//			For Deleting InstructorDetail By Id
//			deletingInstructorDetailById(appDAO);
		};

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
