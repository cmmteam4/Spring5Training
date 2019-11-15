package com.cmm.employee.services;

import java.util.List;

import com.cmm.employee.entity.Attendance;
import com.cmm.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	void saveEmployee(Employee employee);

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int emp_id);

	public List<Employee> getEmployeeBy(String col, String valueOf);

	public boolean checkLogin(String employee_id, String password);

	public List<Employee> getSearchList(Employee emp);

	public void saveAttendance(Attendance attendance, Integer personId);

	public Employee getEmp(String employee_id);

	public int getIdBy(String employee_id);

	public List<Attendance> getAttendance();

	public Attendance getAttendance(int att_id);

	
}
