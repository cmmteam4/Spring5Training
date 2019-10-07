package com.cmm.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmm.employee.dao.EmployeeDao;
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

	

	

	
	
	

}
