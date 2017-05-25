package com.pravin.dao;

import java.util.List;

import com.pravin.model.Designation;

public interface DesignationDao {

	public boolean add(Designation designation);
	public boolean update(Designation designation);
	public boolean delete(Designation designation);
	
	public List<Designation> getAll();
	public Designation getById(int id);
	
}
