package com.pravin.serviceImpl;

import java.util.List;

import com.pravin.dao.IndustrySectorDao;
import com.pravin.daoImpl.IndustrySectorDaoImpl;
import com.pravin.model.IndustrySector;
import com.pravin.service.IndustrySectorService;


public class IndustrySectorServiceImpl implements IndustrySectorService {
	private static IndustrySectorService industrySectorService;
	private static IndustrySectorDao industrySectorDao;
	
	private IndustrySectorServiceImpl() {
		industrySectorDao = IndustrySectorDaoImpl.getInstance();
	}
	
	public static IndustrySectorService getInstance(){
		if(industrySectorService==null)
			industrySectorService = new IndustrySectorServiceImpl();
		return industrySectorService;
	}

	@Override
	public String add(IndustrySector industrySector) {
		if(industrySectorDao.add(industrySector))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String update(IndustrySector industrySector) {
		if(industrySectorDao.update(industrySector))
			return "Success";
		else
			return "Error";
	}

	@Override
	public String delete(IndustrySector industrySector) {
		if(industrySectorDao.delete(industrySector))
			return "Success";
		else
			return "Error";
	}

	@Override
	public List<IndustrySector> getAll() {
		return industrySectorDao.getAll();
	}

	@Override
	public IndustrySector getById(long id) {
		return industrySectorDao.getById(id);
	}

	@Override
	public List<IndustrySector> getByIndustry(int id) {
		return industrySectorDao.getByIndustry(id);
	}

	
	
	
}
