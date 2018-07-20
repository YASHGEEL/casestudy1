package com.cg.payroll.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

@Component(value="payrollServices")
public class PayrollServicesImpl implements PayrollServices{

	@Autowired
	private PayrollDAOServices daoServices;

	@Transactional
	@Override
	public Associate acceptAssociateDetails(Associate associate) throws PayrollServicesDownException {
		return daoServices.save(associate);	
	}

	@Transactional
	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate = getAssociateDetails(associateId);
		//tax calculation code 
		return 0;
	}

	
	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate = daoServices.findOne(associateId);
		if(associate==null)throw new AssociateDetailsNotFoundException("Associate Details with Id "+associateId+" not found" );
		return associate;
	}

	@Override
	public ArrayList<Associate> getAllAssociatesDetails() throws PayrollServicesDownException {
		return (ArrayList<Associate>) daoServices.findAll();
	}


}
