package com.cg.payroll.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.payroll.beans.Associate;
public interface PayrollDAOServices extends JpaRepository<Associate, Integer>{}