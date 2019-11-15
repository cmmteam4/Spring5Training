package com.cmm.employee.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "att_id")
	public Long att_id;

	@Column(name = "employee_id")
	public String employee_id;

	@Column(name = "date")
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	public String date;

	@Column(name = "day")
	public String day;

	@Column(name = "in_time")
	public String in_time;

	@Column(name = "out_time")
	public String out_time;

	@Column(name = "in_time_reason")
	public String in_time_reason;

	@Column(name = "out_time_reason")
	public String out_time_reason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	@DateTimeFormat(pattern="yyyy/mm/dd hh:mm:ss")
	protected java.util.Date created_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	@DateTimeFormat(pattern="yyyy/mm/dd hh:mm:ss")
	protected java.util.Date updated_date;

	@ManyToOne
	@JoinColumn(name = "emp_id", nullable = false)
	private Employee emp;

	public Long getAtt_id() {
		return att_id;
	}

	public void setAtt_id(Long att_id) {
		this.att_id = att_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getIn_time_reason() {
		return in_time_reason;
	}

	public void setIn_time_reason(String in_time_reason) {
		this.in_time_reason = in_time_reason;
	}

	public String getOut_time_reason() {
		return out_time_reason;
	}

	public void setOut_time_reason(String out_time_reason) {
		this.out_time_reason = out_time_reason;
	}

	public java.util.Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(java.util.Date created_date) {
		this.created_date = created_date;
	}

	public java.util.Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(java.util.Date updated_date) {
		this.updated_date = updated_date;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}	

}
