package com.example.crudDemo.rest;


import com.example.crudDemo.entity.Employee;
import com.example.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class EmployeeRestController {
//    quick and Dirty : inject employee dao
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }
//    expose "/employee endpoint? and return a list of employee

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);
        if(e==null){
            throw new RuntimeException("Employee Not Found");
        }else{
            return e;
        }
    }

//    Adding a new Employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employeeId)
    {
//        also just in case they pass an id in JSON ... set Id as 0;
           employeeId.setId(0);

           Employee e = employeeService.save(employeeId);
//        this is to force a save of new item.... instead of Update
        return  e;
    }


    @PutMapping("/employee")
    public Employee putEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }


    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);

        if(e==null){
            throw new RuntimeException("Employee Does not exist");
        }else{
            employeeService.delete(e.getI ));
            return "Deleted Employee "+e;
        }

    }
}
