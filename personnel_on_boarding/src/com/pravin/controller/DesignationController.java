package com.pravin.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.Designation;
import com.pravin.service.DesignationService;
import com.pravin.serviceImpl.DesignationServiceImpl;


@WebServlet("/designation.do")
public class DesignationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static DesignationService designationService;
    public DesignationController() {
        super();
    }

    public void init(){
    	designationService = DesignationServiceImpl.getInstance();
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
			
		}
	}
	
	
	private String add(HttpServletRequest request){
		String designationName = request.getParameter("designation-name");
		
		if(designationName!=null){
			if(!designationName.trim().isEmpty()){
				Designation designation = new Designation();
				designation.setDesignationName(designationName);
				return designationService.add(designation);
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String update(HttpServletRequest request){
		String strDesgId = request.getParameter("designation-id");
		String designationName = request.getParameter("designation-name");
		
		if(strDesgId!=null && designationName!=null){
			if(!strDesgId.trim().isEmpty() && !designationName.trim().isEmpty()){
				Designation designation = new Designation();
				designation.setDesignationId(Integer.parseInt(strDesgId.trim()));
				designation.setDesignationName(designationName);
				return designationService.update(designation);
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String delete(HttpServletRequest request){
		String strDesgId = request.getParameter("designation-id");
		
		
		if(strDesgId!=null){
			if(!strDesgId.trim().isEmpty()){
				try{
				Designation designation = designationService.getById(Integer.parseInt(strDesgId.trim()));
				return designationService.delete(designation);
				}catch(Exception e){
					System.out.println("designation delete "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String getById(HttpServletRequest request){
		String strDesgId = request.getParameter("designation-id");
		
		if(strDesgId!=null){
			if(!strDesgId.trim().isEmpty()){
				try{
				Designation designation = designationService.getById(Integer.parseInt(strDesgId.trim()));
				return "{\"designationId\":\""+designation.getDesignationId()+"\", \"designationName\":\""+designation.getDesignationName()+"\"}";
				}catch(Exception e){
					System.out.println("designation getbyid "+e.getMessage());
					return "Error";
				}
			}else
				return "Error";
		}else
			return "Error";
	}
	
	
	private String getAll(){
		try{
			List<Designation> designations = designationService.getAll();
			if(designations.isEmpty())
				return "Error";
			else{
				int n = 0;
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("[");
				
				for(Designation designation: designations){
					stringBuffer.append("{\"designationId\":\""+designation.getDesignationId()+"\", \"designationName\":\""+designation.getDesignationName()+"\"}");
					n++;
					if(n<designations.size())
						stringBuffer.append(",");
					
				}
				stringBuffer.append("]");
				return stringBuffer.toString();
	
			}
		}catch(Exception e){
			System.out.println("designation getbyid "+e.getMessage());
			return "Error";
		}
	
	}
}
