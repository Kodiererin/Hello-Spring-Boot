package com.ujjwal.crud.cruddemo;

import com.ujjwal.crud.cruddemo.dao.StudentDAO;
import com.ujjwal.crud.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
//		Create the student object
		System.out.println("Creating the new Student Object");
		Student tempStudent = new Student("Hello" , "World", "helloworld@gmail.com");
		System.out.println("Saving the Current Object");
//		Save the student object
		studentDAO.save(tempStudent);

//		Display the saved student id
		System.out.println(tempStudent.getId());
	}
}
