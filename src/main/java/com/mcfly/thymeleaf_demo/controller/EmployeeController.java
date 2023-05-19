package com.mcfly.thymeleaf_demo.controller;

import com.mcfly.thymeleaf_demo.entity.Employee;
import com.mcfly.thymeleaf_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		final List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "list-employees";
	}
}









