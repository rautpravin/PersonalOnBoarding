package com.pravin.dao;

import java.util.List;

import com.pravin.model.Employee;

public interface EmployeeDao {
	
	public boolean add(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(Employee employee);
	public Employee getById(String id);
	public List<Employee> getAll();
	public long getCount();
	
	public List<Employee> getManagers();
}
