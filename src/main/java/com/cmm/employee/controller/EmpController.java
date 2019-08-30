package com.cmm.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmm.employee.entity.Employee;
import com.cmm.employee.services.EmployeeService;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/empform")
	public String showform(Model m) {
		Employee employee = new Employee();
		m.addAttribute("employee", employee);
		return "EMP0001";
	}

	/*@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		if(employee.getEmp_id() == 0) {
			for (int i=0; i<employee.getEmp_id()+1;i++) {
				String emp;
				if (employee.getEmp_id()<10) {
					emp="EMP000"+(employee.getEmp_id()+1);
				}
				else if (employee.getEmp_id()>10 && employee.getEmp_id()<100) {
					emp="EMP00"+(employee.getEmp_id()+1);
				}
				else if (employee.getEmp_id()>100 && employee.getEmp_id()<1000){
					emp="EMP0"+(employee.getEmp_id()+1);
				}
				else {
					
				}
				employee.setEmployee_id(emp);
			}
			empService.saveEmployee(employee);
		}
		else {
			empService.updateEmployee(employee);
		}
		//return new ModelAndView("redirect:/");		
	}*/
	
	/*@RequestMapping(value = "/searchform")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> employee = empService.getAllEmployees();
        model.addObject("employeeSearch", new Employee());
        model.setViewName("EMP0002");
        return model;
    }		*/
	
	@GetMapping("searchform")
	public String search(Model m) {
		Employee employee = new Employee();
		m.addAttribute("employeeSearch",employee);
		return "EMP0002";
	}
	
	@GetMapping("/menuform")
	public String menupage(Model m) {
		Employee employee = new Employee();
		m.addAttribute("menu", employee);
		return "MNU0001";
	}
	
	/*@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        empService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = empService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);
 
        return model;
    }*/



}
