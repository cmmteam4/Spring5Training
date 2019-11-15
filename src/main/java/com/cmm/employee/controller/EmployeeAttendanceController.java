package com.cmm.employee.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmm.employee.entity.Employee;
import com.cmm.employee.entity.Attendance;
import com.cmm.employee.services.EmployeeService;

@SuppressWarnings("unused")
@Controller
public class EmployeeAttendanceController {
	

	@Autowired
	
	private EmployeeService empService;

		
		@RequestMapping(value = "/saveTime", method = RequestMethod.POST)
		public ModelAndView saveTime(@ModelAttribute("menu") Attendance attendance,Employee emp,Model model,HttpSession session) {
		emp = (Employee) session.getAttribute("auth");
		model.addAttribute("auth",emp);
			
		Date dateoperation = new java.sql.Date(new java.util.Date().getTime());
		System.out.println(attendance.getIn_time());
		System.out.println(attendance.getIn_time_reason());
		System.out.println(attendance);	
     	
	    /*to show logined userId and name*/
     	Integer personId = (Integer) session.getAttribute("empId");
		attendance.setCreated_date(dateoperation);
		attendance.setUpdated_date(dateoperation);
		
		
		/*to show current date in Date Column and day column*/
		String pattern="yyyy/MM/dd";
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
		String Date1=simpleDateFormat.format(new java.util.Date());
		attendance.setDate(Date1);			
        System.out.println(Date1);
        String[] daynames = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        attendance.setDay(daynames[day-1]);
        System.out.println(day);
        
      
        
	   /*to show current time in IN box*/
		Date date = new Date();		
		DateFormat df = new SimpleDateFormat("HH:mm");
		String time=df.format(date);
	    attendance.setIn_time(time);
		attendance.setOut_time(time);	
		
		empService.saveAttendance(attendance,personId);
		model.addAttribute("menu",attendance);
		return new ModelAndView("redirect:/menuform");
	
		}
	 /*   Update Attendance from modal*/
		@RequestMapping(value = "/editAttendance", method = RequestMethod.GET)
		public String updateAttendance(HttpServletRequest request,Model m,@ModelAttribute("editatt") Attendance attendance) {
			int att = Integer.parseInt(request.getParameter("id"));
			System.out.println("jjjjjjjjjjjjjjjj"+att);
			attendance = empService.getAttendance(att);
			m.addAttribute("editatt", attendance);
			return "MNU0001";
		}
	
		/*// Update Attendance from modal
				@RequestMapping(value = "/editpop", method = RequestMethod.GET)
				public ModelAndView updatePOP(HttpServletRequest request,Model m,Attendance attendance) {
				//empService.savePOP(attendance);
				return new ModelAndView("redirect:/menuform");
				}
		*/
}
	
	
		
		
		

		

