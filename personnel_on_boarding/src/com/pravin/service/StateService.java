package com.pravin.service;

import java.util.List;

import com.pravin.model.State;

public interface StateService {
	public String add(State state);
	public String update(State state);
	public String delete(State state);
	
	public List<State> getAll();
	public State getById(int id);
	
	public List<State> getByCountryId(int id);
}
