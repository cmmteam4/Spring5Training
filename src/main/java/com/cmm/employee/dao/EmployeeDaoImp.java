package com.cmm.employee.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cmm.employee.entity.Attendance;
import com.cmm.employee.entity.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	
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
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee where " + col + " like '%" + valueOf + "%' ").list();
	}

	public boolean checkLogin(String employee_id, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Employee emp where emp.employee_id like :employee_id and emp.password like :password");
		query.setParameter("employee_id", "%" + employee_id + "%");
		query.setParameter("password", "%" + password + "%");
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}
		session.close();
		return userFound;

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getSearchList(Employee emp) {
		// TODO Auto-generated method stub
//		return sessionFactory.getCurrentSession().createQuery(
//				"from Employee emp where emp.age like :emp_age OR emp.employee_name like :emp_name OR emp.dateOfBirth like :emp_dob")
//				.setParameter("emp_age", "%" + emp.age + "%").setParameter("emp_name", "%" + emp.employee_name + "%")
//				.setParameter("emp_dob", "%" + emp.dateOfBirth + "%").getResultList();
		
		System.out.println(emp.getEmployee_name().trim());

		return sessionFactory.getCurrentSession().createQuery("from Employee emp where emp.employee_name like :emp_name")
				.setParameter("emp_name", "%" + emp.getEmployee_name().trim() + "%").getResultList();
	}
	
	//to add information to attendance with emp_id
	public void saveAttendance(Attendance attendance,Integer personId) {
		Session session = sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		Employee existingPerson = (Employee) session.get(Employee.class,personId);
		System.out.println("Do you add personID?" + personId);
		attendance.setEmp(existingPerson);
		session.save(attendance);
		session.save(existingPerson);
		//sessionFactory.getCurrentSession().save(attendance);
		
	}
    
	//to show logined username and employee_id
	public Employee getEmp(String employee_id) {
		// TODO Auto-generated method stub
		return (Employee) sessionFactory.getCurrentSession().
				createQuery("from Employee e where e.employee_id = :id")
				.setParameter("id", employee_id).uniqueResult();
	}

	public int getIdBy(String employee_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query =  sessionFactory.getCurrentSession()
				.createQuery("select emp_id from Employee emp where employee_id = :employee_id");
		query.setParameter("employee_id", employee_id);
		System.out.println(query.uniqueResult());
		return (Integer) query.uniqueResult();
	}

	
	//to show list from attendance
	@SuppressWarnings("unchecked")
	public List<Attendance> getAttendance() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Attendance").list();
	}
	
	
	// To update attendance
	public Attendance getAttendance(int att_id) {
		// TODO Auto-generated method stub
		return (Attendance) sessionFactory.getCurrentSession().get(Attendance.class, att_id);
	}
	
	

}
