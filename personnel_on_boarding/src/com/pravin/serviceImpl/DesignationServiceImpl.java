package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.DesignationDao;
import com.pravin.daoImpl.DesignationDaoImpl;
import com.pravin.model.Designation;
import com.pravin.service.DesignationService;

public class DesignationServiceImpl implements DesignationService{

	private static DesignationService designationService;
	private static final DesignationDao DESIGNATION_DAO = DesignationDaoImpl.getInstance();
	
	private DesignationServiceImpl() {
	
	}
	
	public static DesignationService getInstance(){
		if(designationService==null)
			designationService = new DesignationServiceImpl();
		return designationService;
	}

	@Override
	public String add(Designation designation) {
		if(DESIGNATION_DAO.add(designation))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String update(Designation designation) {
		if(DESIGNATION_DAO.update(designation))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(Designation designation) {
		if(DESIGNATION_DAO.delete(designation))
			return "Success";
		else
			return "Error";
	}

	@Override
	public List<Designation> getAll() {
		return DESIGNATION_DAO.getAll();
	}

	@Override
	public Designation getById(int id) {
		return DESIGNATION_DAO.getById(id);
	}
	
	
	
}
