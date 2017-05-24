package com.pravin.controller;

import java.text.SimpleDateFormat;

import com.pravin.model.Employee;
import com.pravin.service.EmployeeService;
import com.pravin.serviceImpl.EmployeeServiceImpl;
import com.pravin.util.HibernateUtil;

public class Test {
	public static void main(String[] args){
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		Employee e1 = new Employee();
		e1.setEmployeeId(employeeService.generateEmpId());
		e1.setEmployeeName("Employee 1");
		e1.setGender("male");
		
		try{
		e1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-1990"));
		}catch(Exception e){ e.printStackTrace(); }
		
		System.out.println(employeeService.add(e1));
		HibernateUtil.shutdown();
		
	}
}
