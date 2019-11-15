package com.cmm.employee.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "employee_id")
	private String employee_id;

	@Column(name = "employee_name")
	private String employee_name;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "note")
	private String note;

	@Column(name = "def_flg")
	private int def_flg;

	@Column(name = "password")
	public String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	@DateTimeFormat(pattern = "yyyy/mm/dd hh:mm:ss")
	protected Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	@DateTimeFormat(pattern = "yyyy/mm/dd hh:mm:ss")
	protected Date updated_date;

	@OneToMany(mappedBy = "emp")
	private Set<Attendance> attendance;


	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDef_flg() {
		return def_flg;
	}

	public void setDef_flg(int def_flg) {
		this.def_flg = def_flg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Set<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", employee_id=" + employee_id + ", employee_name=" + employee_name
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender + ", note=" + note
				+ ", def_flg=" + def_flg + ", password=" + password + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + ", attendance=" + attendance + "]";
	}

}
