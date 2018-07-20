package com.cg.payroll.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class URIController {

	
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	
	
	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	
	@ModelAttribute("associate")
		public Associate getAssociate() {
		return new Associate();
	}
	
}
