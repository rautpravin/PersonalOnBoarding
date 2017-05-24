package com.pravin.dao;

import java.util.List;

import com.pravin.model.City;


public interface CityDao {

	public boolean add(City city);
	public boolean update(City city);
	public boolean delete(City city);
	
	public List<City> getAll();
	public City getById(long id);
	
	public List<City> getByStateId(long id);
	
}
