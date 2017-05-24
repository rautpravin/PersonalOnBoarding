package com.pravin.service;

import java.util.List;

import com.pravin.model.Country;

public interface CountryService {
	public String add(Country country);
	public String update(Country country);
	public String delete(Country country);
	public Country getById(int id);
	public List<Country> getAll();
}
