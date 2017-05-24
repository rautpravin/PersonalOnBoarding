package com.pravin.service;

import java.util.List;

import com.pravin.model.City;

public interface CityService {

	public String add(City city);
	public String update(City city);
	public String delete(City city);
	
	public List<City> getAll();
	public City getById(long id);
	
	public List<City> getByStateId(long id);
	
}
