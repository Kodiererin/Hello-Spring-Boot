package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

//    Add a Method to Sory by last Name
    public List<Employee> findAllByOrderByLastNameAsc();
//    This was not a build In function.
//    We created it and so it will auto make it.

}
