package com.pravin.service;

import java.util.List;

import com.pravin.model.IndustrySector;

public interface IndustrySectorService {

	public String add(IndustrySector industrySector);
	public String update(IndustrySector industrySector);
	public String delete(IndustrySector industrySector);
	
	public List<IndustrySector> getAll();
	
	public IndustrySector getById(long id);
	
	public List<IndustrySector> getByIndustry(int id);
	
}
