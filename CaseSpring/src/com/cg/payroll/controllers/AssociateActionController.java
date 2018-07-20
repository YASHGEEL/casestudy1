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
public class AssociateActionController {

	
	@Autowired(required=true)
	private PayrollServices payrollServices;
	
	@RequestMapping(value="/registerAssociate",method=RequestMethod.POST)
	public ModelAndView registerAssociate(@ModelAttribute("associate") Associate associate) {
		try {
			associate =payrollServices.acceptAssociateDetails(associate);
			ModelAndView modelAndView = new ModelAndView("registrationSuccessPage", "associate", associate);
			return modelAndView;
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
}
