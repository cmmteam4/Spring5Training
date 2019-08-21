package com.cmm.employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmm.employee.entity.Employee;

public abstract class EmployeeDao {
	@Autowired
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		Session session = sessionFactory.getCurrentSession();
		Employee emp1 = new Employee();
		emp1.setEmployee_id("EMP001");
		emp1.setEmployee_name("MaMa");
		emp1.setDate_of_birth("1997/03/12");
		emp1.setAge(22);
		emp1.setGender("Female");
		emp1.setNote("Hello");
		emp1.setDef_flg(0);
		emp1.setPassword("1234567");

		session.save(emp1);

	}

}
