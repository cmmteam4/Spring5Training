package com.cmm.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		// Session currentSession = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		// currentSession.save(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	// To update employee info,getting id
	public Employee getEmployee(int emp_id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, emp_id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeBy(String col, String valueOf) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee where "+col+" like '%"+valueOf+"%' ").list();
	}

	public boolean checkLogin(String employee_id, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee emp where emp.employee_id like :employee_id and emp.password like :password");
		query.setParameter("employee_id", "%" + employee_id + "%");
		query.setParameter("password","%" + password + "%");
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		session.close();
		return userFound;  
		
	}
	
	
	
	
	
	
	
	
	
}
