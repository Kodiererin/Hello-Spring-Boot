package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
//		To Get The Data From Database.
		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "Employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee",theEmployee);

		return "Employees/EmployeeForm";
	}


	@PostMapping("/save")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee){
//		Save the employee
		employeeService.save(employee);
//		use a redirect to prevent the duplicate submission
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId , Model theModel) {
//		Get The Employee From the Service
		Employee theEmployee = employeeService.findById(theId);
//		Set Employee  in the model to prepoluate the form
		theModel.addAttribute("employee",theEmployee);
//		Send over to our form.
		return "employees/EmployeeForm";

	}

	@GetMapping("/delete")
	public String showFormForDelete(@RequestParam("employeeId") int theId) {
//		Get The Employee From the Service
		employeeService.deleteById(theId);
//		Set Employee  in the model to prepoluate the form
//		Send over to our form.
		return "redirect:/employees/list";

	}


}









