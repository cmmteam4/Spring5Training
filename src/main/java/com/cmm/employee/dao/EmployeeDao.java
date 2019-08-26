package com.cmm.employee.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmm.employee.entity.Employee;

public abstract class EmployeeDao {
	@Autowired
	private static SessionFactory sessionFactory;

	private EntityManager em;

	public EmployeeDao(EntityManager em) {
		super();
		this.em = em;
	}

}
