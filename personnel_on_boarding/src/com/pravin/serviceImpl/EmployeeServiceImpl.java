package com.pravin.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.pravin.dao.EmployeeDao;
import com.pravin.daoImpl.EmployeeDaoImpl;
import com.pravin.model.Employee;
import com.pravin.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeDao employeeDao;
	
	static{
		employeeDao = new EmployeeDaoImpl();
	}
	

	@Override
	public String add(Employee employee) {
		if(employeeDao.add(employee))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String update(Employee employee) {
		if(employeeDao.update(employee))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(Employee employee) {
		if(employeeDao.delete(employee))
			return "Success";
		else
			return "Error";
	}

	@Override
	public Employee getById(String id) {
		return  employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public String generateEmpId() {
		long count = employeeDao.getCount();
		String eid = "SC"+(count+1);
		return eid;
	}

	@Override
	public List<String[]> getManagers() {
		List<Object[]> temp = employeeDao.getManagers();
		List<String[]> managers = new ArrayList<>();
		for(Object[] t: temp){
			String[] s = new String[2];
			s[0] = ""+t[0];
			s[1] = ""+t[1];
			managers.add(s);
		}
		return managers;
	}

}
