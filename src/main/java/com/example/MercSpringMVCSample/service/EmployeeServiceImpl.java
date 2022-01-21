package com.example.MercSpringMVCSample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MercSpringMVCSample.dao.IEmployeeDAO;
import com.example.MercSpringMVCSample.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO daoRef;

	@Override
	public void addEmployee(Employee employee) {
		daoRef.save(employee);

	}

	@Override
	public List<Employee> getAllEmployee() {
		return daoRef.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return daoRef.getOne(empId);
	}

	@Override
	public void updateEmployee(Employee employee, int empId) {
		daoRef.save(employee);

	}

	@Override
	public void deleteEmployee(int empId) {
		daoRef.deleteById(empId);

	}

}
