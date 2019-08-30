package com.cmm.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cmm.employee.entity.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(employee);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();		
	}

	
	

	
}
