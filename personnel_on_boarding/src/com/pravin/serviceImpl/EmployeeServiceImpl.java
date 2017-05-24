package com.pravin.serviceImpl;

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
			return "Employee record added successfully";
		else
			return "Unable to add Employee record";
	}

	@Override
	public String update(Employee employee) {
		if(employeeDao.update(employee))
			return "Employee record updated successfully";
		else
			return "Unable to update Employee record";
	}

	@Override
	public String delete(Employee employee) {
		if(employeeDao.delete(employee))
			return "Employee record deleted successfully";
		else
			return "Unable to delete Employee record";
	}

	@Override
	public Employee getById(String id) {
		return  employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = employeeDao.getAll();
		
		return employees;
	}

	@Override
	public String generateEmpId() {
		long count = employeeDao.getCount();
		String eid = "SC"+(count+1);
		return eid;
	}

}
