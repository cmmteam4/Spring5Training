package com.cmm.employee.dao;

import java.util.List;

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
	public List<Employee> searchEmployee(String name) {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createQuery("from Employee where employee_name like '%"+name+"%' ").list();
			
		}
}
