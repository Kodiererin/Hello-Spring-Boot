package com.example.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudDemo.entity.Employee;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
//    Done
//    There is No need to write any code.
//    This is the beauty of Spring JPAREpository

}
