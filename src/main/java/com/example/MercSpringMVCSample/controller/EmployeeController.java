package com.example.MercSpringMVCSample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MercSpringMVCSample.model.Employee;
import com.example.MercSpringMVCSample.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	IEmployeeService serviceRef;

	@RequestMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("successMsg", "Welcome to Spring Boot Heroku Training !!!");
		return "Homepage";
	}

	@RequestMapping("/addNewEmployee")
	public String addNewEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "NewEmployee";
	}

	@RequestMapping("/addEmployeeDetails")
	public String addEmployeeDetails(@ModelAttribute("employee") Employee employee, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "NewEmployee";
		} else {
			serviceRef.addEmployee(employee);
			model.addAttribute("successMsg", "Data Inserted Successfully");
			return "Homepage";
		}

	}

	@RequestMapping("/getAllEmployee")
	public String getAllEmployee(Model model) {
		List<Employee> empList = serviceRef.getAllEmployee();
		model.addAttribute("employeeList", empList);
		return "employeeview";
	}

	@RequestMapping("/employee")
	public String Employee(Model model, @RequestParam("empId") int empId) {

		Employee emp = serviceRef.getEmployeeById(empId);
		model.addAttribute("employeeData", emp);
		return "EmployeeOperation";

	}

	@RequestMapping("/updateEmployee")
	public String updateEmployee(Model model, @RequestParam("empId") int empId) {

		Employee emp = serviceRef.getEmployeeById(empId);
		model.addAttribute("employeeDetails", emp);
		return "updateEmployeePage";
	}

	@RequestMapping("/updateEmployeeDetails")
	public String updateEmployeeDetails(@ModelAttribute("employee") Employee employee, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "NewEmployee";
		} else {
			serviceRef.updateEmployee(employee, employee.getEmpId());
			model.addAttribute("successMsg", "Employee Updated Successfully");
			return "Homepage";
		}

	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(Model model, @RequestParam("empId") int empId) {
		serviceRef.deleteEmployee(empId);
		model.addAttribute("successMsg", "Employee Deleted Successfully");
		return "Homepage";
	}

}
