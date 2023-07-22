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
//			createStudent(studentDAO);
//			We creted single students now we will create multiple Students
//			createMultipleStudents(studentDAO);

//			Implementing the Find Student
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
//		Create a student object
		Student student = new Student("Hello","India","helloIndia");
//		Save the student
		studentDAO.save(student);
//		Display the id of the saved student
		System.out.println("The Id of the Student is "+student.getId());
		int id = student.getId();
//		retrieve student based on the id: primary key
		Student getStudent = studentDAO.findById(id);
		System.out.println(getStudent);
	}

	public void createMultipleStudents(StudentDAO studentDAO){
//		The objective of this function was to see if the id is autoincrementing or not.
		System.out.println("Creating multiple Students");
		Student s1 = new Student("Ujjwal","Kumar","whoisujjwal@gmail.com");
		Student s2 = new Student("Kumar ","ujjwal" , "iamujjwal@gmail.com");
		Student s3 = new Student("iam","ujjwal","iamujjwal@gmail.com");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
//		And the ID was autoincrementing.
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
