package com.cmm.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmm.employee.dao.EmployeeDao;
import com.cmm.employee.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeDao empDao;
	
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDao.saveEmployee(employee);			
	}	
	
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
		
	}

	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
	}

	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
	
	
	
	
		

