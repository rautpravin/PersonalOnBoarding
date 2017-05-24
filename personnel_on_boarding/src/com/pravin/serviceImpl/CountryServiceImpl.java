package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.CountryDao;
import com.pravin.daoImpl.CountryDaoImpl;
import com.pravin.model.Country;
import com.pravin.service.CountryService;

public class CountryServiceImpl implements CountryService {
	
	private static CountryService countryService;
	private final CountryDao countryDao;
	
	private CountryServiceImpl() {
		countryDao = CountryDaoImpl.getInstance();
	}
	
	public static CountryService getInstance(){
		if(countryService==null)
			countryService = new CountryServiceImpl();
		return countryService;
	}

	@Override
	public String add(Country country) {
		if(countryDao.add(country))
			return "Success : Country record added successfully!";
		else
			return "Error : Unable to add Country record!";
	}

	@Override
	public String update(Country country) {
		if(countryDao.update(country))
			return "Success: Country Record updated successfully!";
		else
			return "Error : Unable to update Country record!";
		
	}

	@Override
	public String delete(Country country) {
		if(countryDao.delete(country))
			return "Success : Country record deleted successfully!";
		else 
			return "Error : Unable to delete Country Record!";
	}

	@Override
	public Country getById(int id) {
		return countryDao.getById(id);
	}

	@Override
	public List<Country> getAll() {
		return countryDao.getAll();
	}
	

}
