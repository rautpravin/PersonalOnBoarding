package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.StateDao;
import com.pravin.daoImpl.StateDaoImpl;
import com.pravin.model.State;
import com.pravin.service.StateService;

public class StateServiceImpl implements StateService {
	private static StateService stateService;
	private static StateDao stateDao;
	
	private StateServiceImpl(){
		
	}
	
	public static StateService getInstance(){
		if(stateService == null){
			stateService = new StateServiceImpl();
			stateDao = StateDaoImpl.getInstance();
		}
		return stateService;
	}

	@Override
	public String add(State state) {
		if(stateDao.add(state))
			return "Success";
		else
			return "Error";
	}

	
	@Override
	public String update(State state) {
		if(stateDao.update(state))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(State state) {
		if(stateDao.delete(state))
			return "Success";
		else
			return "Error";
	}

	@Override
	public List<State> getAll() {
		return stateDao.getAll();
	}

	@Override
	public State getById(int id) {
		return stateDao.getById(id);
	}

	@Override
	public List<State> getByCountryId(int id) {
		return stateDao.getByCountryId(id);
	}
	
}
