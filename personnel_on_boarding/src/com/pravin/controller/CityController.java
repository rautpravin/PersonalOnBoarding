package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.City;
import com.pravin.model.State;
import com.pravin.service.CityService;
import com.pravin.service.StateService;
import com.pravin.serviceImpl.CityServiceImpl;
import com.pravin.serviceImpl.StateServiceImpl;

@WebServlet("/city.do")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static CityService cityService;
	private static StateService stateService;
	
    public CityController() {
        super();
    }
    
    public void init(){
    	cityService = CityServiceImpl.getInstance();
    	stateService = StateServiceImpl.getInstance();
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
			
		case "getall":
			out.print(getAll());
			break;
			
		case "getbyid":
			out.print(getById(request));
			break;
			
		case "getbystate":
			out.print(getByStateId(request));
			break;
			
		}
	}
	
	
	private String add(HttpServletRequest request){
		String cityName = request.getParameter("city-name");
		String strStateId = request.getParameter("state-id");
		
		if(cityName!=null && strStateId!=null){
			if(!cityName.trim().isEmpty() && !strStateId.trim().isEmpty()){
				try{
					int stateId = Integer.parseInt(strStateId.trim());
					City city = new City();
					city.setCityName(cityName);
					State state = stateService.getById(stateId);
					city.setState(state);
					return cityService.add(city);
				}catch(Exception e){
					System.out.println("Exception : city-controller - add : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
		
	}


	private String update(HttpServletRequest request){
		String strCityId = request.getParameter("city-id");
		String cityName = request.getParameter("city-name");
		String strStateId = request.getParameter("state-id");
		System.out.println("city id : "+strCityId+"\t cityName : "+cityName+"\t StateId : "+strStateId);
		if(strCityId!=null && cityName!=null && strStateId!=null){
			if(!strCityId.trim().isEmpty() && !cityName.trim().isEmpty() && !strStateId.trim().isEmpty()){
				try{
					long cityId = Long.parseLong(strCityId.trim()); 
					int stateId = Integer.parseInt(strStateId.trim());
					City city = new City();
					city.setCityId(cityId);
					city.setCityName(cityName);
					State state = stateService.getById(stateId);
					city.setState(state);
					return cityService.update(city);
				}catch(Exception e){
					System.out.println("Exception : city-controller - update : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
		
	}
	
	

	private String delete(HttpServletRequest request){
		String strCityId = request.getParameter("city-id");
		if(strCityId!=null){
			if(!strCityId.trim().isEmpty()){
				try{
					long cityId = Long.parseLong(strCityId.trim());
					City city = cityService.getById(cityId);
					return cityService.delete(city);
				}catch(Exception e){
					System.out.println("Exception : city-controller - delete : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
			
		}else
			return "Error";
	}
	
	
	private String getById(HttpServletRequest request){
		String strCityId = request.getParameter("city-id");
		if(strCityId!=null){
			if(!strCityId.trim().isEmpty()){
				try{
					long cityId = Long.parseLong(strCityId.trim());
					City city = cityService.getById(cityId);
					return "{\"cityId\":\""+city.getCityId()+"\", \"cityName\":\""+city.getCityName()+"\", \"stateId\":\""+city.getState().getStateId()+"\", \"stateName\":\""+city.getState().getStateName()+"\", \"countryId\":\""+city.getState().getCountry().getCountryId()+"\" ,\"countryName\":\""+city.getState().getCountry().getCountryName()+"\" }";
				}catch(Exception e){
					System.out.println("Exception : city-controller - getbyid : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
			
		}else
			return "Error";
	}

	
	private String getAll(){
		try{
			StringBuffer stringBuffer = new StringBuffer();
			List<City> cities = cityService.getAll();
			if(cities.isEmpty()){
				return "Error";
			}else{
				int n = 0;
				stringBuffer.append("[");
				for(City city: cities){
					stringBuffer.append("{\"cityId\":\""+city.getCityId()+"\", \"cityName\":\""+city.getCityName()+"\", \"stateId\":\""+city.getState().getStateId()+"\", \"stateName\":\""+city.getState().getStateName()+"\", \"countryId\":\""+city.getState().getCountry().getCountryId()+"\" ,\"countryName\":\""+city.getState().getCountry().getCountryName()+"\" }");
					n++;
					if(n<cities.size())
						stringBuffer.append(",");
				}
				stringBuffer.append("]");
				return stringBuffer.toString(); 
			}
		}catch(Exception e){
			System.out.println("Exception : city-controller - getall : "+e.getMessage());
			return "Error";
		}
	}
	
	
	private String getByStateId(HttpServletRequest request){
		String strStateId = request.getParameter("state-id");
		StringBuffer stringBuffer = new StringBuffer();
		if(strStateId!=null){
			if(!strStateId.trim().isEmpty()){
				try{
					int stateId = Integer.parseInt(strStateId.trim());
					List<City> cities = cityService.getByStateId(stateId);
					if(cities.isEmpty()){
						return "Error";
					}else{
						int n = 0;
						stringBuffer.append("[");
						for(City city: cities){
							stringBuffer.append("{\"cityId\":\""+city.getCityId()+"\", \"cityName\":\""+city.getCityName()+"\", \"stateId\":\""+city.getState().getStateId()+"\", \"stateName\":\""+city.getState().getStateName()+"\", \"countryId\":\""+city.getState().getCountry().getCountryId()+"\" ,\"countryName\":\""+city.getState().getCountry().getCountryName()+"\" }");
							n++;
							if(n<cities.size())
								stringBuffer.append(",");
						}
						stringBuffer.append("]");
						return stringBuffer.toString(); 
					}
					
				}catch(Exception e){
					System.out.println("Exception : city-controller - getbystateid : "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
			
		}else
			return "Error";
	}
	
}
