package com.pravin.dao;

import java.util.List;

import com.pravin.model.Industry;

public interface IndustryDao {
	
	public boolean add(Industry industry);
	public boolean update(Industry industry);
	public boolean delete(Industry industry);
	
	public List<Industry> getAll();
	public Industry getById(int id);
	
}
