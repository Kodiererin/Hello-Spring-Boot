package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation  implements  EmployeeDAO{


//    Define Fields for Entitymanager
    private EntityManager entityManager;

//    Set up constructor injection
    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
//    Entity Manager is automatically created by Spring Boot
    @Override
    public List<Employee> findAll() {
//        Create a Query

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee ",Employee.class);

//        Execute query and get result list
        List<Employee> employees = theQuery.getResultList();
//        Return the resut
        return employees;
    }

    @Override
    public Employee findById(int theId) {
//        Get the Employee
        Employee e = entityManager.find(Employee.class , theId);
//        Return the Employee
        return e;
    }

    @Override
    public Employee save(Employee theEmployee) {
//      Save the Employee
        Employee e = entityManager.merge(theEmployee);

//        Retyrn the Employee
        return e;
    }

    @Override
    public void delete(int theId) {
//      Find the Employee
        Employee e = entityManager.find(Employee.class , theId);
//        Delete the Employee
        entityManager.remove(e);
//        Return the Message

    }
}
