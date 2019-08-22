package com.cmm.employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmm.employee.entity.Employee;

public abstract class EmployeeDao {
	@Autowired
	private static SessionFactory sessionFactory;

	

}
