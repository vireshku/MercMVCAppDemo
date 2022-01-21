package com.example.MercSpringMVCSample.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MercSpringMVCSample.model.Employee;

public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {

	List<Employee> findByDeptName(String deptName);

}
