package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.Country;
import com.pravin.service.CountryService;
import com.pravin.serviceImpl.CountryServiceImpl;

@WebServlet("/country.do")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CountryService countryService;
	
    public CountryController() {
        super();
    }

    public void init(){
    	countryService = CountryServiceImpl.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	private void handle(HttpServletRequest request, HttpServletResponse response) {
		try{
			PrintWriter out = response.getWriter();
			String action = request.getParameter("action");
			
			switch(action){
			case "add":
				out.print(addCountry(request));
				break;
				
			case "update":
				out.println(updateCountry(request));
				break;
				
			case "delete":
				out.println(deleteCountry(request));
				break;
				
			case "getbyid":
				out.println(getById(request));
				break;
				
			case "getall":
				out.println(getAll(request));
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String addCountry(HttpServletRequest request){
		String countryName = request.getParameter("countryName");
		boolean f = false;
		
		if(countryName!=null){
			if(!countryName.trim().isEmpty()) f = true;
		}
		
		if(f){
			Country country = new Country();
			country.setCountryName(countryName);
			return countryService.add(country);
		}else
			return "Error";
	}

	private String updateCountry(HttpServletRequest request){
		String strId = request.getParameter("countryId");
		int id = 0;
		String countryName = request.getParameter("countryName");
		boolean f = false;
		if(strId!=null && countryName!=null){
			if(!strId.trim().isEmpty() && !countryName.trim().isEmpty()){
				try{
					id = Integer.parseInt(request.getParameter("countryId").trim());
					f = true;
				}catch(Exception e){
					System.out.println("\nExceptionClass : "+e.getClass()+"\nCause : "+e.getCause()+"\nMessage : "+e.getMessage());
				}
			}
		}
		
		if(f){	
			Country country = new Country();
			country.setCountryId(id);
			country.setCountryName(countryName);
			return countryService.update(country);
		}else
			return "Error";
		
	}
	
	private String deleteCountry(HttpServletRequest request){
		String strId = request.getParameter("countryId");
		int id = 0;
		boolean f = false;
		if(strId!=null){
			if(!strId.trim().isEmpty()){
				try{
					id = Integer.parseInt(request.getParameter("countryId").trim());
					f = true;
				}catch(Exception e){
					System.out.println("\nExceptionClass : "+e.getClass()+"\nCause : "+e.getCause()+"\nMessage : "+e.getMessage());
				}
			}
		}
		if(f){
			Country country = countryService.getById(id);
			if(country!=null)
				return countryService.delete(country);
			else
				return "Error";
		}else
			return "Error";
	}
	
	private String getById(HttpServletRequest request){
		String strId = request.getParameter("countryId");
		int id = 0;
		boolean f = false;
		if(strId!=null){
			if(!strId.trim().isEmpty()){
				try{
					id = Integer.parseInt(request.getParameter("countryId").trim());
					f = true;
				}catch(Exception e){
					System.out.println("\nExceptionClass : "+e.getClass()+"\nCause : "+e.getCause()+"\nMessage : "+e.getMessage());
				}
			}		
		}
		if(f){
			Country country = countryService.getById(id);
			if(country==null)
				return "Error";
			else{
				return "{\"countryId\":\""+country.getCountryId()+"\",\"countryName\":\""+country.getCountryName()+"\"}";
			}
		}else
			return "Error";
	}
	
	private String getAll(HttpServletRequest request){
		List<Country> list = countryService.getAll();
		
		if(!list.isEmpty()){
			StringBuffer allRec = new StringBuffer();
			allRec.append("[");
			int n = 0;
			for(Country c: list){
				allRec.append("{\"countryId\":\""+c.getCountryId()+"\", \"countryName\":\""+c.getCountryName()+"\"}");
				n++;
				if(n<list.size())
					allRec.append(",");
			}
			allRec.append("]");
			
			return allRec.toString();
		}else{
			return "Error";
		}
		
	}
	
}
