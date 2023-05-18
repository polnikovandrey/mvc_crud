package com.mcfly.thymeleaf_demo.controller;

import com.mcfly.thymeleaf_demo.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {

		Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
		Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
		Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");

		theEmployees = new ArrayList<>();

		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}
}









