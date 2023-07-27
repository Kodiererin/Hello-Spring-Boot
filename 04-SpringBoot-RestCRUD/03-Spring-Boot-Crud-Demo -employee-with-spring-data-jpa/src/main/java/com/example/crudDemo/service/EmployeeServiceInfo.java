package com.example.crudDemo.service;

import com.example.crudDemo.dao.EmployeeDAO;
import com.example.crudDemo.dao.EmployeeRepository;
import com.example.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public abstract class EmployeeServiceInfo implements EmployeeService {


    private EmployeeRepository theEmployeeRepository;
    @Autowired
    public EmployeeServiceInfo(EmployeeRepository theEmployeeRepository){
        this.theEmployeeRepository = theEmployeeRepository;
    }

    EmployeeServiceInfo(){}

    @Override
    public List<Employee> findAll() {
        return theEmployeeRepository.findAll();
    }


    public Employee findById(int theId) {
        Optional<Employee> result = theEmployeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException();
        }
        return theEmployee;
    }

    public Employee save(Employee theEmployee) {
        return theEmployeeRepository.save(theEmployee);
    }
    public void deleteById(int theId) {
        theEmployeeRepository.deleteById(theId);
    }

}
