package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.Industry;
import com.pravin.service.IndustryService;
import com.pravin.serviceImpl.IndustryServiceImpl;

@WebServlet("/industry.do")
public class IndustryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static IndustryService industryService;
	
    public IndustryController() {
        super();
    }

    public void init(){
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
			
		case "getall":
			out.print(getAll());
			break;
		
		case "getbyid":
			out.print(getById(request));
			break;
			
		}
	}
	
	
	private String add(HttpServletRequest request){
		String industryName = request.getParameter("industry-name");
		if(industryName!=null){
			if(!industryName.trim().isEmpty()){
				Industry industry = new Industry();
				industry.setIndustryName(industryName);
				return industryService.add(industry);
			}else{
				return "Error";
			}
		}else{
			return "Error";
		}
	}
	
	
	private String update(HttpServletRequest request){
		String strIndustryId = request.getParameter("industry-id");
		String industryName = request.getParameter("industry-name");
		if(strIndustryId!=null && industryName!=null){
			if(!strIndustryId.trim().isEmpty() && !industryName.trim().isEmpty()){
				try{
				Industry industry = new Industry();
				industry.setIndustryId(Integer.parseInt(strIndustryId.trim()));
				industry.setIndustryName(industryName);
				return industryService.update(industry);
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
		String strIndustryId = request.getParameter("industry-id");
		
		if(strIndustryId!=null){
			if(!strIndustryId.trim().isEmpty()){
				try{
				Industry industry = new Industry();
				industry.setIndustryId(Integer.parseInt(strIndustryId.trim()));
				return industryService.delete(industry);
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

	
	private String getAll(){
		List<Industry> industries = new ArrayList<>();
		try{
			industries = industryService.getAll();
			if(industries.isEmpty())
				return "Error";
			else{
				int n = 0;
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("[");
				for(Industry industry: industries){
					stringBuffer.append("{");
					stringBuffer.append("\"industryId\":\""+industry.getIndustryId()+"\",");
					stringBuffer.append("\"industryName\":\""+industry.getIndustryName()+"\"");
					stringBuffer.append("}");
					n++;
					if(n<industries.size())
						stringBuffer.append(",");
				}
				stringBuffer.append("]");
				return stringBuffer.toString();
			}
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}
	
	
	private String getById(HttpServletRequest request){
		String strIndustryId = request.getParameter("industry-id");
		if(strIndustryId!=null){
			if(!strIndustryId.trim().isEmpty()){
				try{
					Industry industry = industryService.getById(Integer.parseInt(strIndustryId.trim()));
					String json = "{";
					json+="\"industryId\":\""+industry.getIndustryId()+"\",";
					json+="\"industryName\":\""+industry.getIndustryName()+"\"";
					json+="}";
					return json;
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
}
