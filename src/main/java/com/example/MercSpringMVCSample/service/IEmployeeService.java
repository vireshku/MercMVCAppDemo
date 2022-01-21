package com.example.MercSpringMVCSample.service;

import java.util.List;

import com.example.MercSpringMVCSample.model.Employee;

public interface IEmployeeService {
	
	void addEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int empId);
	
	void updateEmployee(Employee employee, int empId);
	
	void deleteEmployee(int empId);

}
