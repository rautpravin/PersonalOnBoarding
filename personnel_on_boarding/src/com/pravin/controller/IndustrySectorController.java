package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.Industry;
import com.pravin.model.IndustrySector;
import com.pravin.service.IndustrySectorService;
import com.pravin.service.IndustryService;
import com.pravin.serviceImpl.IndustrySectorServiceImpl;
import com.pravin.serviceImpl.IndustryServiceImpl;

@WebServlet("/industry_sector.do")
public class IndustrySectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IndustrySectorService industrySectorService;
	private IndustryService industryService;
	
    public IndustrySectorController() {
        super();
    }

    
    public void init(){
    	industrySectorService = IndustrySectorServiceImpl.getInstance();
    	industryService = IndustryServiceImpl.getInstance();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		
		switch(action){
		case "add":
			out.print(add(request));
			break;
			
		case "update":
			out.print(update(request));
			break;
		
		case "delete":
			out.print(delete(request));
			break;
			
		case "getbyid":
			out.print(getById(request));
			break;
			
		case "getall":
			out.print(getAll());
			break;
			
		case "getbyindustry":
			out.print(getByIndustryId(request));
			break;
		}
	}
	
	
	private String add(HttpServletRequest request){
		String industrySectorName = request.getParameter("industry-sector-name");
		
		String strIndustryId = request.getParameter("industry-id");
		if(industrySectorName!=null && strIndustryId!=null){
			if(!industrySectorName.trim().isEmpty() && !strIndustryId.trim().isEmpty()){
				try{
					IndustrySector industrySector = new IndustrySector();
					industrySector.setSectorName(industrySectorName);
					Industry industry = industryService.getById(Integer.parseInt(strIndustryId.trim()));
					industrySector.setIndustry(industry);
					return industrySectorService.add(industrySector);
				}catch(Exception e){
					System.out.println("1) Exception - industry-sector-controller : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String update(HttpServletRequest request){
		
		String strSectorId = request.getParameter("industry-sector-id");
		String industrySectorName = request.getParameter("industry-sector-name");
		String strIndustryId = request.getParameter("industry-id");
		if(strSectorId!=null && industrySectorName!=null && strIndustryId!=null){
			if(!strSectorId.trim().isEmpty() && !industrySectorName.trim().isEmpty() && !strIndustryId.trim().isEmpty()){
				try{
					
					IndustrySector industrySector = new IndustrySector();
					industrySector.setSectorId(Long.parseLong(strSectorId.trim()));
					industrySector.setSectorName(industrySectorName);
					Industry industry = industryService.getById(Integer.parseInt(strIndustryId.trim()));
					industrySector.setIndustry(industry);
					return industrySectorService.update(industrySector);
				}catch(Exception e){
					System.out.println("2) Exception - industry-sector-controller : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String delete(HttpServletRequest request){
		
		String strSectorId = request.getParameter("industry-sector-id");
		
		if(strSectorId!=null){
			if(!strSectorId.trim().isEmpty()){
				try{
					IndustrySector industrySector = new IndustrySector();
					industrySector.setSectorId(Long.parseLong(strSectorId.trim()));
					return industrySectorService.delete(industrySector);
				}catch(Exception e){
					System.out.println("3) Exception - industry-sector-controller : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}


	private String getById(HttpServletRequest request){
		String strSectorId = request.getParameter("industry-sector-id");
		if(strSectorId!=null){
			if(!strSectorId.trim().isEmpty()){
				try{
					IndustrySector is = industrySectorService.getById(Long.parseLong(strSectorId.trim()));
					
					return "{\"sectorId\":\""+is.getSectorId()+"\", \"sectorName\":\""+is.getSectorName()+"\", \"industryId\":\""+is.getIndustry().getIndustryId()+"\", \"industryName\":\""+is.getIndustry().getIndustryName()+"\"}";
				}catch(Exception e){
					System.out.println("4) Exception - industry-sector-controller : "+e.getMessage());
					return "Error";
				}
			}else{
				return "Error";
			}
		}else
			return "Error";
	}
	
	
	private String getAll(){
		try{
			List<IndustrySector> industrySectors = industrySectorService.getAll();
			if(industrySectors.isEmpty()){
				return "Error";
			}else{
				int n = 0;
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("[");
				for(IndustrySector is:industrySectors){
					stringBuffer.append("{\"sectorId\":\""+is.getSectorId()+"\", \"sectorName\":\""+is.getSectorName()+"\", \"industryId\":\""+is.getIndustry().getIndustryId()+"\", \"industryName\":\""+is.getIndustry().getIndustryName()+"\"}");
					n++;
					if(n<industrySectors.size())
						stringBuffer.append(",");
				}
				stringBuffer.append("]");
				return stringBuffer.toString();
			}
		}catch(Exception e){
			return "Error";
		}
	}
	
	
	private String getByIndustryId(HttpServletRequest request){
		String strIndustryId = request.getParameter("industry-id");
		if(strIndustryId!=null){
			if(!strIndustryId.trim().isEmpty()){
				try{
					List<IndustrySector> industrySectors = industrySectorService.getByIndustry(Integer.parseInt(strIndustryId.trim()));
					if(industrySectors.isEmpty()){
						return "Error";
					}else{
						int n = 0;
						StringBuffer stringBuffer = new StringBuffer();
						stringBuffer.append("[");
						for(IndustrySector is:industrySectors){
							stringBuffer.append("{\"sectorId\":\""+is.getSectorId()+"\", \"sectorName\":\""+is.getSectorName()+"\", \"industryId\":\""+is.getIndustry().getIndustryId()+"\", \"industryName\":\""+is.getIndustry().getIndustryName()+"\"}");
							n++;
							if(n<industrySectors.size())
								stringBuffer.append(",");
						}
						stringBuffer.append("]");
						return stringBuffer.toString();
					}
					
				}catch(Exception e){
					System.out.println("4) Exception - industry-sector-controller : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
}
