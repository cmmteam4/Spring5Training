package com.cmm.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmm.employee.entity.Attendance;
import com.cmm.employee.entity.Employee;
import com.cmm.employee.services.EmployeeService;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService empService;

	// EMP0001
	@GetMapping("/empform")
	public String showform(Model m) {
		Employee employee = new Employee();
		m.addAttribute("employee", employee);
		return "EMP0001";
	}

	// Save Employee (EMP0001)
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
		Date dateoperation = new java.sql.Date(new java.util.Date().getTime());
		for (int i = 0; i < employee.getEmp_id() + 1; i++) {
			String emp;
			if (employee.getEmp_id() < 10) {
				emp = "EMP000" + (employee.getEmp_id());
				employee.setEmployee_id(emp);
			} else if (employee.getEmp_id() >= 10 && employee.getEmp_id() < 100) {
				emp = "EMP00" + (employee.getEmp_id());
				employee.setEmployee_id(emp);
			} else if (employee.getEmp_id() >= 100 && employee.getEmp_id() < 1000) {
				emp = "EMP0" + (employee.getEmp_id());
				employee.setEmployee_id(emp);
			} else {
				emp = "EMP" + (employee.getEmp_id());
				employee.setEmployee_id(emp);
			}
			employee.setCreated_date(dateoperation);
			employee.setUpdated_date(dateoperation);
			empService.saveEmployee(employee);
		}
		// empService.saveEmployee(employee);
		return new ModelAndView("redirect:/empform");
	}

	// EMP0002
	@GetMapping("/searchform")
	public String search(Model m) {
		Employee employee = new Employee();
		List<Employee> emp = empService.getEmployee();
		m.addAttribute("ListEmp", emp);
		m.addAttribute("employeeSearch", employee);
		return "EMP0002";
	}

	@RequestMapping(value = "/searchEmp", method = RequestMethod.POST)
	public String searchEmployee(@ModelAttribute("employeeSearch") Employee emp, Model m) {
		System.out.println(emp.getEmployee_name());
		List<Employee> name = empService.getEmployeeBy("employee_name", String.valueOf(emp.getEmployee_name()));
		System.out.println("EMP LIST: " + name.get(0).getEmployee_name());

		System.out.println(emp.getAge());
		List<Employee> ageList = empService.getEmployeeBy("age", String.valueOf(emp.getAge()));
		System.out.println("EMP LIST: " + ageList.get(0).getAge());

		System.out.println(emp.getGender());
		List<Employee> genderList = empService.getEmployeeBy("gender", emp.getGender());
		//System.out.println("EMP LIST: " + genderList.get(0).getGender());

		// List<Employee> allSearch = empService.getEmployeeByTwo("");

		if (emp.getEmployee_name() == null) {

		} else {
			m.addAttribute("ListEmp", name);
		}
		if (emp.getAge() == 0) {

		} else {
			m.addAttribute("ListEmp", ageList);
		}
		if (emp.getGender() == null) {
			return "EMP0002";
		} else {
			m.addAttribute("ListEmp", genderList);
		}
		return "EMP0002";
	}

	// MNU0001
	@GetMapping("/menuform")
	public String menupage(Model m) {
		Attendance empAttendance = new Attendance();
		m.addAttribute("menu", empAttendance);
		return "MNU0001";
	}

	// LOG0001
	@GetMapping("/loginform")
	public String loginpage(Model m) {
		Employee employee = new Employee();
		m.addAttribute("emplogin", employee);
		return "LOG0001";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String Login(@ModelAttribute("emplogin") Employee emp, Model m) {
		System.out.println(emp.getEmployee_id());
		System.out.println(emp.getPassword());
		boolean userExist = empService.checkLogin(emp.getEmployee_id(), emp.getPassword());
		m.addAttribute("menu",new Attendance());
		if (userExist) {
			return "MNU0001";
		} else {
			return "LOG0001";
		}
	}

	// Delete Employee (EMP0002)
	@RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		for (String id : request.getParameterValues("emp_id"))
			// int employeeId = Integer.parseInt(request.getParameter("emp_id"));
			// empService.deleteEmployee(employeeId);
			empService.deleteEmployee(Integer.parseInt(id));
		return new ModelAndView("redirect:/searchform");
	}

	// update Employee
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employee = Integer.parseInt(request.getParameter("id"));
		Employee Employee = empService.getEmployee(employee);
		ModelAndView model = new ModelAndView("EMP0001");
		model.addObject("employee", Employee);
		return model;
	}

}
