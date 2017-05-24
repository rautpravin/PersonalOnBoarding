package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.IndustryDao;
import com.pravin.daoImpl.IndustryDaoImpl;
import com.pravin.model.Industry;
import com.pravin.service.IndustryService;

public class IndustryServiceImpl implements IndustryService{

	private static IndustryService industryService;
	
	private static final IndustryDao INDUSTRY_DAO = IndustryDaoImpl.getInstance();
	
	private IndustryServiceImpl() {
		
	}
	
	public static IndustryService getInstance(){
		if(industryService==null)
			industryService = new IndustryServiceImpl();
		
		return industryService;
	}

	@Override
	public String add(Industry industry) {
		if(INDUSTRY_DAO.add(industry))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String update(Industry industry) {
		if(INDUSTRY_DAO.update(industry))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(Industry industry) {
		if(INDUSTRY_DAO.delete(industry))
			return "Success";
		else
			return "Error";
	}

	@Override
	public List<Industry> getAll() {
		return INDUSTRY_DAO.getAll();
	}

	@Override
	public Industry getById(int id) {
		return INDUSTRY_DAO.getById(id);
	}
	
	
}
