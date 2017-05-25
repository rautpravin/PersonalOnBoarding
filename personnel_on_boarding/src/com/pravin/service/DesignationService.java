package com.pravin.service;

import java.util.List;

import com.pravin.model.Designation;

public interface DesignationService {

	public String add(Designation designation);
	public String update(Designation designation);
	public String delete(Designation designation);
	
	public List<Designation> getAll();
	public Designation getById(int id);
	
}
