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
import com.pravin.model.State;
import com.pravin.service.CountryService;
import com.pravin.service.StateService;
import com.pravin.serviceImpl.CountryServiceImpl;
import com.pravin.serviceImpl.StateServiceImpl;

@WebServlet("/state.do")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private static StateService stateService;
	private static CountryService countryService;
    public StateController() {
        super();
    }

    @Override
	public void init(){
		stateService = StateServiceImpl.getInstance();
		countryService = CountryServiceImpl.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action")+"";
		PrintWriter out = response.getWriter();
		
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
			
		case "getbycountry":
			out.print(getByCountry(request));
			break;
			
		}
	}
	
	private String add(HttpServletRequest request){
		String stateName = request.getParameter("state-name");
		String strCountryId = request.getParameter("country-id");
		if(stateName!=null && strCountryId!=null){
			if(!stateName.trim().isEmpty() && !strCountryId.trim().isEmpty()){
				try{
					State state = new State();
					state.setStateName(stateName);
					Country country = countryService.getById(Integer.parseInt(strCountryId.trim()));
					state.setCountry(country);
					return stateService.add(state);
				}catch(Exception e){
					e.printStackTrace();
					return "Error";
				}
			}else{
				return "Error";
			}
		}else{
			return "Error";
		}
		
	}
	
	private String update(HttpServletRequest request){
		String strStateId = request.getParameter("state-id");
		String stateName = request.getParameter("state-name");
		String strCountryId = request.getParameter("country-id");
		
		if(strStateId!=null && stateName!=null && strCountryId!=null){
			if(!strStateId.trim().isEmpty() && !stateName.trim().isEmpty() && !strCountryId.trim().isEmpty()){
				try{
					State state = new State();
					state.setStateId(Integer.parseInt(strStateId.trim()));
					state.setStateName(stateName);
					Country country = countryService.getById(Integer.parseInt(strCountryId.trim()));
					state.setCountry(country);
					
					return stateService.update(state);
				}catch(Exception e){
					e.printStackTrace();
					return "Error";
				}
			}else{
				return "Error";
			}
		}else
			return "Error";
	}

	
	private String delete(HttpServletRequest request){
		String strStateId = request.getParameter("state-id");
		if(strStateId!=null){
			if(!strStateId.trim().isEmpty()){
				try{
					State state = stateService.getById(Integer.parseInt(strStateId.trim()));
					return stateService.delete(state);
				}catch(Exception e){
					e.printStackTrace();
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	private String getById(HttpServletRequest request){
		String strStateId = request.getParameter("state-id");
		if(strStateId!=null){
			if(!strStateId.trim().isEmpty()){
				try{
					State s = stateService.getById(Integer.parseInt(strStateId.trim()));
					String json = "{\"stateId\":\""+s.getStateId()+"\", \"stateName\":\""+s.getStateName()+"\",\"countryId\":\""+s.getCountry().getCountryId()+"\",\"countryName\":\""+s.getCountry().getCountryName()+"\" }";
					System.out.println(json);
					return json;
				}catch(Exception e){
					e.printStackTrace();
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	private String getAll(){
		
		List<State> states = stateService.getAll();
		
		if(states.isEmpty()){
			return "Error";
		}
		else{
			StringBuffer allRec = new StringBuffer();
			int n = 0;
			allRec.append("[");
			for(State s: states){
					allRec.append("{\"stateId\":\""+s.getStateId()+"\", \"stateName\":\""+s.getStateName()+"\",\"countryId\":\""+s.getCountry().getCountryId()+"\",\"countryName\":\""+s.getCountry().getCountryName()+"\" }");
					n++;
					if(n<states.size())
						allRec.append(",");
			}
			allRec.append("]");
			System.out.println(allRec.toString());
			return allRec.toString();
		}
	
		
	}
	

	
	private String getByCountry(HttpServletRequest request){
		String strCountryId = request.getParameter("country-id");
		if(strCountryId!=null){
			if(!strCountryId.trim().isEmpty()){
				try{
					List<State> states = stateService.getByCountryId(Integer.parseInt(strCountryId.trim()));
					
					if(states.isEmpty()){
						return "Error";
					}
					else{
						StringBuffer allRec = new StringBuffer();
						int n = 0;
						allRec.append("[");
						for(State s: states){
							
								allRec.append("{\"stateId\":\""+s.getStateId()+"\", \"stateName\":\""+s.getStateName()+"\",\"countryId\":\""+s.getCountry().getCountryId()+"\",\"countryName\":\""+s.getCountry().getCountryName()+"\" }");
								n++;
								if(n<states.size())
									allRec.append(",");
						}
						allRec.append("]");
						System.out.println(allRec.toString());
						
						return allRec.toString();
					}
				}catch(Exception e){
					e.printStackTrace();
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}

}
