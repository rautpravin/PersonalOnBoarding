package com.pravin.dao;

import java.util.List;

import com.pravin.model.IndustrySector;

public interface IndustrySectorDao {
	public boolean add(IndustrySector industrySector);
	public boolean update(IndustrySector industrySector);
	public boolean delete(IndustrySector industrySector);
	
	public List<IndustrySector> getAll();
	
	public IndustrySector getById(long id);
	
	public List<IndustrySector> getByIndustry(int id);
	
}
