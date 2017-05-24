package com.pravin.dao;

import java.util.List;

import com.pravin.model.State;

public interface StateDao {
	public boolean add(State state);
	public boolean update(State state);
	public boolean delete(State state);
	
	public List<State> getAll();
	public State getById(int id);
	
	public List<State> getByCountryId(int id);
	
}
