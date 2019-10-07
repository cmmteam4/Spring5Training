package com.cmm.employee.services;

import java.util.List;

import com.cmm.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	void saveEmployee(Employee employee);

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int emp_id);

	public List<Employee> getEmployeeBy(String col, String valueOf);

	public boolean checkLogin(String employee_id, String password);

	

	

	

	

	
	
	
}
