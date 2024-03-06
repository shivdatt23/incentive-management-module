package com.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.EmployeeDao;
import com.org.dto.Employee;


@Controller
public class RegisterAndLoginController {
	
	@Autowired
	private EmployeeDao dao;
	
	
	@RequestMapping("/userregister")
	public ModelAndView registerUser(@ModelAttribute Employee employee) {
		dao.saveEmployee(employee);
		ModelAndView mav=new ModelAndView("user_register.jsp");
		return mav;
	}
	
	
	
	@RequestMapping("/userlogin")
	public ModelAndView loginUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		
		Employee employee = dao.verifyUser(email,password);
		
		if(employee==null) {
		ModelAndView mav=new ModelAndView("user_login.jsp");
		session.setAttribute("fail", "Invalid Credentials");
		return mav;
		}
		else {
		ModelAndView mav=new ModelAndView("user_home.jsp");
		mav.addObject("employeeObj",employee);
		session.setAttribute("employeeObj", employee);
		return mav;
	}
	}
	
	
	
	
	
	
	@RequestMapping("/adminlogin")
	public ModelAndView loginAdmin(@RequestParam String email,@RequestParam String password,HttpSession session) {
		
		if(email.equals("admin@gmail.com")&&password.equals("admin")) {
			ModelAndView mav=new ModelAndView("admin_home.jsp");
			
			return mav;
			
		}else {
			
			ModelAndView mav=new ModelAndView("admin_login.jsp");
			session.setAttribute("fail","Invalid credentials");

			return mav;
		}
	}
	
	
	@RequestMapping("/logoutadmin")
	public ModelAndView logoutAdmin(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("base_home.jsp");
		return mav;
	}
	
	
	@RequestMapping("/logoutuser")
	public ModelAndView logoutUser(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("base_home.jsp");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
