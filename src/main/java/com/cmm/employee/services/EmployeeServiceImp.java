package com.cmm.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmm.employee.dao.EmployeeDao;
import com.cmm.employee.entity.Attendance;
import com.cmm.employee.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDao.saveEmployee(employee);

	}

	@Transactional
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return empDao.getEmployee();
	}	

	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		empDao.deleteEmployee(employeeId);		
		
	}
    
	
	//update employee id
	public Employee getEmployee(int emp_id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(emp_id);
	}

	public List<Employee> getEmployeeBy(String col, String valueOf) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeBy(col,valueOf);
	}
	
	@Transactional
	public boolean checkLogin(String employee_id, String password) {
		// TODO Auto-generated method stub
		return empDao.checkLogin(employee_id,password);
	}

	public List<Employee> getSearchList(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.getSearchList(emp);
	}
	
	 //to show logined username and employee_id
	@Transactional
	public void saveAttendance(Attendance attendance, Integer personId) {
		// TODO Auto-generated method stub
		empDao.saveAttendance(attendance, personId);
		
	}
	
   
	@Transactional
	public Employee getEmp(String employee_id) {
		// TODO Auto-generated method stub
		return empDao.getEmp(employee_id);
	}

	

	public int getIdBy(String employee_id) {
		// TODO Auto-generated method stub
		return empDao.getIdBy(employee_id);
	
	}
	
	
	@Transactional
	public List<Attendance> getAttendance() {
		// TODO Auto-generated method stub
		return empDao.getAttendance();
	}
	
  
	

	//update Attendance
	public Attendance getAttendance(int att_id) {
		// TODO Auto-generated method stub
		return empDao.getAttendance(att_id);
	}


}
