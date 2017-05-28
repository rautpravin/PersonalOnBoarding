package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.CityDao;
import com.pravin.daoImpl.CityDaoImpl;
import com.pravin.model.City;
import com.pravin.service.CityService;

public class CityServiceImpl implements CityService{

	private static CityService cityService;
	private static final CityDao CITY_DAO = CityDaoImpl.getInstance();
	
	private CityServiceImpl(){
	}
	
	public static CityService getInstance(){
		if(cityService==null)
			cityService = new CityServiceImpl();
		
		return cityService;
	}

	@Override
	public String add(City city) {
		if(CITY_DAO.add(city))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String update(City city) {
		if(CITY_DAO.update(city))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(City city) {
		if(CITY_DAO.delete(city))
			return "Success";
		else
			return "Error";
	}

	@Override
	public List<City> getAll() {
		return CITY_DAO.getAll();
	}

	@Override
	public City getById(long id) {
		return CITY_DAO.getById(id);
	}

	@Override
	public List<City> getByStateId(int id) {
		return CITY_DAO.getByStateId(id);
	}
	
	
	
}
