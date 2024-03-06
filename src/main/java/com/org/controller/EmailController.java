package com.org.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.EmployeeDao;
import com.org.dao.HolidayPackageDao;
import com.org.dto.Employee;
import com.org.dto.HolidayPackage;

@Controller
public class EmailController {
	
	@Autowired
	private EmployeeDao dao;
	@Autowired
	HolidayPackageDao holidayDao;
	
	@RequestMapping("/sendemail")
	public ModelAndView sendemail(@RequestParam int id, @RequestParam String email) {
		
		
		
		
		Employee employee = dao.fetchUserById(id);
		
		int sales = employee.getTotalSales();
		double ip = employee.getIncentivePercentage();
		String hpe = employee.getHpe();
		int bonus = employee.getBonus();
		
		List<HolidayPackage> list = holidayDao.fetchAll();
		
		String msg=""
				+ "YOUR PERFORMANCE \n"
				+ "--------------------------------- \n"
				+ "Total Sales : "+sales
				+ "\n "
				+ "Incentive Percentage : "+ip+"%"
				+ "\n "
				+ "Your Bonus : "+"$"+bonus
				+ "\n "
				+ "Holiday Package Eligibility : "+hpe
				+"\n ------------------------------------------";
				
		
		//holiday adding to mail
		
		if(hpe.equals("Yes")) {
			
			if(sales>=70000) {
				msg+="\n"+list.get(2).toString();
			}
			else if(sales>=60000) {
				msg+="\n"+list.get(1).toString();
			}
			else {
				msg+="\n"+list.get(0).toString();
			}
				
					
		}
		
		
		
		
		//email sending logic
		
		Properties p = System.getProperties();
		
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "465");
		p.setProperty("mail.smtp.ssl.enable", "true");
		p.setProperty("mail.smtp.auth",  "true");
		
		
		Session session = Session.getInstance(p,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("shivdattbibhar23@gmail.com","********");
			}
		});
		
		session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		
		try {
		message.setFrom("shivdattbibhar23@gmail.com");
		
		InternetAddress arr=new InternetAddress();

		
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
		message.setSubject("Incentive Manager Updates");
		
		
		message.setText(msg);
		
		
		Transport.send(message);

		
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav=new ModelAndView("employee_incentives");
		return mav;
		
	}

}
