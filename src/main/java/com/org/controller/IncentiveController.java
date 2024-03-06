package com.org.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
public class IncentiveController {
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping("/employee_incentives")
	public ModelAndView employeeIncentives(){
		
		List<Employee> list = dao.fetchAll();
		
		ModelAndView mav=new ModelAndView("employee_incentive.jsp");
		mav.addObject("list",list);
		return mav;
		
		
	}
	
	
	@RequestMapping("/userupdate")
	public ModelAndView update(@RequestParam int id) {
		
		System.out.println(id);
		
		Employee employee = dao.fetchUserById(id);
		
		
		
		
		
		ModelAndView mav=new ModelAndView("user_update.jsp");
		
		mav.addObject("updatedEmployee",employee);
	
		return mav;
		
	}
	
	@RequestMapping("/userupdate_details")
	public ModelAndView updateDetails(@ModelAttribute Employee employee) {
		
		
		Employee updateEmp = dao.fetchUserById(employee.getId());
		
		updateEmp.setName(employee.getName());
		updateEmp.setEmail(employee.getEmail());
		
		
		int sales=employee.getTotalSales();
		updateEmp.setTotalSales(sales);
		
		//logic area when updating sales
		
		//add incentive percent
		//add bonus
		//add hpe
		if(sales>=10000) {
			if(sales<20000) {
					updateEmp.setIncentivePercentage(1.5);
			
			}else if(sales<30000) {
				updateEmp.setIncentivePercentage(3.0);
			}else if(sales<50000) {
				updateEmp.setIncentivePercentage(3.5);
				updateEmp.setBonus(1000);
			}else {
					updateEmp.setIncentivePercentage(5.0);
					updateEmp.setHpe("Yes");
				}
		}
		
		
		Employee empl = dao.updateUser(updateEmp);
		System.out.println(empl.getName()+" updated successfully");
		
		
		ModelAndView mav=new ModelAndView("employee_incentives");
		
		return mav;
		
	}
	
	
	@RequestMapping("/useradd")
	public ModelAndView adduser(@ModelAttribute Employee employee) {

		ModelAndView mav=new ModelAndView("user_add.jsp");
		return mav;
	}
	
	
	
	@RequestMapping("/useradd_admin")
	public ModelAndView adduseradmin(@ModelAttribute Employee employee) {
		dao.addUser(employee);
		ModelAndView mav=new ModelAndView("employee_incentives");
		return mav;
	}
	
	
	@RequestMapping("/userdelete")
	public ModelAndView deleteuser(@RequestParam int id) {
		System.out.println(id);
		
		ModelAndView mav=new ModelAndView("employee_incentives");
		
		dao.deleteUser(id);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	

}
