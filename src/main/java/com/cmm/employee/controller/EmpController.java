package com.cmm.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	// EMP0001 form
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
		System.out.println(employee);
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

	// EMP0002 form
	@GetMapping("/searchform")
	public String search(Model m) {
		Employee employee = new Employee();
		List<Employee> emp = empService.getEmployee();
		m.addAttribute("ListEmp", emp);
		m.addAttribute("employeeSearch", employee);
		return "EMP0002";
	}

	// SearchEmployee (name,age,gender)
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
		// System.out.println("EMP LIST: " + genderList.get(0).getGender());

		// List<Employee> allSearch = empService.getEmployeeByTwo("");

		if (emp.getEmployee_name() == null) {

		} else {
			m.addAttribute("ListEmp", name);
		}

//		System.out.println("hello");
//		return new ModelAndView("redirect:/searchform");

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

//	// MNU0001	form
	@RequestMapping(value = "/menuform", method = RequestMethod.GET)
	public String menupage(@ModelAttribute("menu") Attendance empAttendance, Model m, HttpSession session) {
		Date dateoperation = new java.sql.Date(new java.util.Date().getTime());

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm");
		String inTime = df.format(date);

		empAttendance.setIn_time(inTime);
		m.addAttribute("empAttendance", empAttendance);
		System.out.println(df.format(date));

		/* to show list of attendance */
		List<Attendance> att = empService.getAttendance();
		m.addAttribute("ListAttend", att);

		/* to show logined userId and name */
		Integer personId = (Integer) session.getAttribute("empId");
		empAttendance.setCreated_date(dateoperation);
		empAttendance.setUpdated_date(dateoperation);
		m.addAttribute("menu", empAttendance);
	//	empService.saveAttendance(empAttendance, personId);
		return "MNU0001";
	}

	// LOG0001 form
	@GetMapping("/loginform")
	public String loginpage(Model m) {
		Employee employee = new Employee();
		m.addAttribute("emplogin", employee);
		return "LOG0001";
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute("emplogin") Employee emp, Model model, HttpServletRequest req) {
		System.out.println(emp.getEmployee_id());
		System.out.println(emp.getPassword());
		Employee theemployee = empService.getEmp(emp.getEmployee_id());

		/* to show logined userId and name */
		HttpSession session = req.getSession();
		session.setAttribute("auth", theemployee);
		int empl = empService.getIdBy(emp.getEmployee_id());
		session.setAttribute("empId", empl);
		Employee authemp = (Employee) session.getAttribute("auth");

		boolean userExist = empService.checkLogin(emp.getEmployee_id(), emp.getPassword());
		// m.addAttribute("menu",new Attendance());
		if (userExist) {

			/* to show current time in IN box */
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm");
			String time = df.format(date);
			Attendance attendance = new Attendance();
			attendance.setIn_time(time);
			attendance.setOut_time(time);
			model.addAttribute("menu", attendance);

			/* to show list of attendance */
			List<Attendance> att = empService.getAttendance();
			model.addAttribute("ListAttend", att);

			return "MNU0001";

		} else {

			return "LOG0001";
		}
		// to get emp_id

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

	// Update Employee
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employee = Integer.parseInt(request.getParameter("id"));
		Employee Employee = empService.getEmployee(employee);
		ModelAndView model = new ModelAndView("EMP0001");
		model.addObject("employee", Employee);
		return model;
	}

	// Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/";
	}
	
	

}
