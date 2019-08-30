package com.cmm.employee.services;

import java.util.List;

import com.cmm.employee.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(int employeeId);

	Employee getEmployee(int employeeId);

	void updateEmployee(Employee employee);	

}
