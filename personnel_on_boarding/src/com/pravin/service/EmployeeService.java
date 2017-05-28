package com.pravin.service;

import java.util.List;

import com.pravin.model.Employee;

public interface EmployeeService {
	
	public String add(Employee employee);
	public String update(Employee employee);
	public String delete(Employee employee);
	public Employee getById(String id);
	public List<Employee> getAll();
	public String generateEmpId();
	public List<Employee> getManagers();
	
}
