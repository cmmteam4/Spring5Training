package com.cmm.employee.dao;

import com.cmm.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> getEmployee();

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int emp_id);

	public List<Employee> getEmployeeBy(String col, String valueOf);

	public boolean checkLogin(String employee_id, String password);

	

	

	

	

	

}
