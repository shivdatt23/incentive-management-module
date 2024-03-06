package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.HolidayPackageDao;
import com.org.dto.HolidayPackage;

@Controller
public class HolidayController {
	
	@Autowired
	private HolidayPackageDao dao;

	@RequestMapping("/addholiday")
	public ModelAndView addHoliday() {
		ModelAndView mav = new ModelAndView("add_holiday_form.jsp");
		
		return mav;
	}
	
	@RequestMapping("/add_hp")
	public ModelAndView addHoliday(@ModelAttribute HolidayPackage holidayPackage) {
		System.out.println(holidayPackage.getHolidayName());
		HolidayPackage hp = dao.addHoliday(holidayPackage);
		
		ModelAndView mav = new ModelAndView("holiday_package_manager");
		return mav;
	}
	
	
	@RequestMapping("/holiday_package_manager")
	public ModelAndView holidayManager() {
		
		List<HolidayPackage> list = dao.fetchAll();
		
		ModelAndView mav = new ModelAndView("holiday_package_mgmt.jsp");
		
		mav.addObject("list",list);
		return mav;
	}
	
}
