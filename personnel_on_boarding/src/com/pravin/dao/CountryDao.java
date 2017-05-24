package com.pravin.dao;

import java.util.List;

import com.pravin.model.Country;

public interface CountryDao {

	public boolean add(Country country);
	public boolean update(Country country);
	public boolean delete(Country country);
	public Country getById(int id);
	public List<Country> getAll();
}
