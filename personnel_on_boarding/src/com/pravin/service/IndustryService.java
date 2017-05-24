package com.pravin.service;

import java.util.List;

import com.pravin.model.Industry;

public interface IndustryService {

	public String add(Industry industry);
	public String update(Industry industry);
	public String delete(Industry industry);
	
	public List<Industry> getAll();
	public Industry getById(int id);
	
}
