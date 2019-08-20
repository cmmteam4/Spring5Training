package com.cmm.employee.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EmployeeDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	    // ...


}
