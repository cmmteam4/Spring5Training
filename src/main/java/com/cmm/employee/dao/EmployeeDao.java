package com.cmm.employee.dao;

import java.util.List;

import com.cmm.employee.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	

	

}
