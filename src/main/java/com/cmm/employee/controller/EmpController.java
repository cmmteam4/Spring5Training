package com.cmm.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmm.employee.entity.Employee;

@Controller 
public class EmpController {
	@RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("employee", new Employee());  
        return "EMP0001";   
    }  
	
	  

}
