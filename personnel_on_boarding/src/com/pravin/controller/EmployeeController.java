package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.pravin.daoImpl.IndustrySectorDaoImpl;
import com.pravin.model.BankDetails;
import com.pravin.model.City;
import com.pravin.model.Designation;
import com.pravin.model.EducationalQualDetails;
import com.pravin.model.Employee;
import com.pravin.model.ExperienceDetails;
import com.pravin.model.IndustrySector;
import com.pravin.service.CityService;
import com.pravin.service.DesignationService;
import com.pravin.service.EmployeeService;
import com.pravin.service.IndustrySectorService;
import com.pravin.serviceImpl.CityServiceImpl;
import com.pravin.serviceImpl.DesignationServiceImpl;
import com.pravin.serviceImpl.EmployeeServiceImpl;
import com.pravin.serviceImpl.IndustrySectorServiceImpl;
import com.pravin.util.HibernateUtil;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmployeeService employeeService; 
	private static CityService cityService;
	private static IndustrySectorService industrySectorService;
	private static DesignationService designationService;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	
    public EmployeeController() {
        super();
    }

    public void init(){
    	 employeeService = new EmployeeServiceImpl();
    	 cityService = CityServiceImpl.getInstance();
    	 industrySectorService = IndustrySectorServiceImpl.getInstance();
    	 designationService = DesignationServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action")+"";
		
		switch (action) {
		case "add": 
			out.print(add(request));
			break;

		case "update":
			
			break;
			
		case "delete":
			
			break;
			
		case "getall":
			
			break;
			
		case "getbyid":
			
			break;
		
		case "getmanagers":
			out.print(getManagers());
			break;
			
		default:
			
			break;
		}
	}
	

	private String getManagers(){
		try{
			List<Employee> managers = employeeService.getManagers();
			if(!managers.isEmpty()){
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("[");
				int n = 0;
				for(Employee manager : managers){
					stringBuffer.append("{\"managerId\":\""+manager.getEmployeeId()+", \"managerName\":\""+manager.getEmployeeName()+"\"}");
					n++;
					if(n<managers.size())
						stringBuffer.append(",");
				}
				stringBuffer.append("]");
				return stringBuffer.toString();
			}else{
				return "Error";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}
	
	
	
	private String add(HttpServletRequest request){
		try{
			Employee employee = getEmployeeDetails(request);
			setBankDetails(employee, request);
			
			setEducationalQualDetails(employee, request);
			setExperienceDetails(employee, request);
			return employeeService.add(employee);
			
		}catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
	}

	private Employee getEmployeeDetails(HttpServletRequest request){
		Employee e = new Employee();
		
		String firstName = request.getParameter("first-name");
		String middleName = request.getParameter("middle-name");
		String lastName = request.getParameter("last-name");
		String strBirthDate = request.getParameter("birth-date");
		String gender = request.getParameter("gender");
		String maritalStatus = request.getParameter("marital-status");
		
		String emailId = request.getParameter("email-id");
		String mobileExtNo = request.getParameter("mobile-ext-no");
		String mobileNo = request.getParameter("mobile-no");
		String landline = request.getParameter("landline-no");
		String emergencyContPerson = request.getParameter("emergency-contact-person-name");
		String emergencyContNo = request.getParameter("emergency-contact-no");
		
		String flatBuildingNo = request.getParameter("flat-building-no");
		String street1 = request.getParameter("street-lane1");
		String street2 = request.getParameter("street-lane2");
		String landmark = request.getParameter("landmark");
		String location = request.getParameter("location");
		String strCityId = request.getParameter("cities");
		String pincode = request.getParameter("pincode");
		String addrProof = request.getParameter("address-proof");
		String otherAddrProof = request.getParameter("other-address-proof-name");
		String proofIdNo = request.getParameter("proof-id-no");
		
		String strJoinDate = request.getParameter("joining-date");
		String strleaveDate = request.getParameter("leaving-date");
		String strDesgId = request.getParameter("designations");
		String strAllocationCityId = request.getParameter("allocation-city");
		String strIndustrySectorId = request.getParameter("assigned-sector");
		String strManagerId = request.getParameter("reporting-manager");
		String strCtc = request.getParameter("ctc");
		String expType = request.getParameter("experience-type");
		
		boolean isNull = firstName==null & middleName==null && lastName==null && strBirthDate==null && gender==null &&
				maritalStatus==null && emailId==null && mobileExtNo==null && mobileNo==null && 
				emergencyContPerson==null && emergencyContNo==null && flatBuildingNo==null && street2==null &&
				landmark==null && location==null && strCityId==null && pincode==null && addrProof==null &&
				otherAddrProof==null && proofIdNo==null && strJoinDate==null && strDesgId==null
				&& strAllocationCityId==null && strIndustrySectorId==null && strManagerId==null && strCtc==null;
		
		if(!isNull){
			try{
				e.setEmployeeId(employeeService.generateEmpId());
				e.setEmployeeName(firstName+" "+middleName+" "+lastName);
				e.setBirthDate(DATE_FORMAT.parse(strBirthDate));
				e.setGender(gender);
				e.setMaritalStatus(maritalStatus);
				e.setEmailId(emailId);
				e.setMobileNo(mobileExtNo+" "+mobileNo);
				e.setLandlineNo(landline);
				e.setEmergencyContactPersonName(emergencyContPerson);
				e.setEmergencyContactNo(emergencyContNo);
				
				e.setFlatBuildingNo(flatBuildingNo);
				e.setStreetLane1(street1);
				e.setStreetLane2(street2);
				e.setLandmark(landmark);
				e.setLocation(location);
				e.setPincode(pincode);
				e.setAddrProofDocType(addrProof);
				e.setOtherAddrProofType(otherAddrProof);
				e.setAddrProofDocId(proofIdNo);
				e.setExperienceType(expType);
				
				if(!strDesgId.trim().isEmpty()){
					Designation desg = designationService.getById(Integer.parseInt(strDesgId.trim()));
					e.setDesignation(desg);
					
				}
				if(!strIndustrySectorId.trim().isEmpty()){
					IndustrySector industrySector = industrySectorService.getById(Long.parseLong(strIndustrySectorId.trim()));
					e.setIndustrySector(industrySector);
				}
				if(!strCityId.trim().isEmpty()){
					City city = cityService.getById(Long.parseLong(strCityId.trim()));
					e.setCity(city);
				}
				
				e.setJoiningDate(DATE_FORMAT.parse(strJoinDate));
				if(!strleaveDate.trim().isEmpty())
					e.setLeavingDate(DATE_FORMAT.parse(strleaveDate));
		
			
			}catch(Exception ex){
				System.out.println("getEmployeeDetails() : "+ex.getMessage());
			}
		}
		
		return e;
	}
	
	private boolean setBankDetails(Employee employee, HttpServletRequest request){
		boolean flag = false;
		String acNo = request.getParameter("account-number");
		String acHolderName = request.getParameter("account-holders-name");
		String acType = request.getParameter("account-type");
		String branch = request.getParameter("branch-name");
		String ifsc = request.getParameter("ifsc-code");
		
		boolean isNull = acNo==null && acHolderName==null && acType==null && branch==null && ifsc==null;
		if(!isNull){
			boolean isEmpty = acNo.trim().isEmpty() && acHolderName.trim().isEmpty() 
							   && acType.trim().isEmpty() && branch.trim().isEmpty() && ifsc.trim().isEmpty();
			
			if(!isEmpty){
				BankDetails bankDetails = new BankDetails();
				bankDetails.setAcHolderName(acHolderName);
				bankDetails.setAcNo(acNo);
				bankDetails.setAcType(acType);
				bankDetails.setBranchName(branch);
				bankDetails.setIfscCode(ifsc);
				bankDetails.setEmployee(employee);
				
				employee.setBankDetails(bankDetails);
				flag = true;
			}
		}
		return flag;
	}
	
	
	private boolean setExperienceDetails(Employee employee, HttpServletRequest request){
		boolean flag = false;
		
		String strAllExpNo = request.getParameter("all-exp-no");
		if(strAllExpNo!=null)
		{
			if(!strAllExpNo.trim().isEmpty()){
				int n = 0;
				try{ n = Integer.parseInt(strAllExpNo.trim());	}
				catch(Exception e){	System.out.println("1) Exception : getExperienceDetails() : "+e.getMessage());	}
				
				for(int i=1;i<=n;i++){
					String employerName = request.getParameter("employer-name"+i);
					String designation = request.getParameter("designation"+i);
					String strDurationFrom = request.getParameter("duration-from"+i);
					String strDurationTill = request.getParameter("duration-till"+i);
					String strIndustryId  = request.getParameter("industries"+i);
					String strIndustrySectorId = request.getParameter("sectors"+i);
					//String totalExperience = request.getParameter("total-experience"+i);
					String strCtcFixed  = request.getParameter("ctc-fixed"+i); 
					String strCtcvariable = request.getParameter("ctc-variable"+i); 
					String refName1  = request.getParameter("ref-name1"+i);
					String refContact1  = request.getParameter("ref-contact1"+i);
					String refName2    = request.getParameter("ref-name2"+i);
					String refContact2    = request.getParameter("ref-contact2"+i);
					
					boolean isNotNull = employerName!=null && designation!=null && strDurationFrom!=null && strDurationTill!=null
								&& strIndustryId!=null && strIndustrySectorId!=null && strCtcFixed!=null && strCtcvariable!=null 
								&& refName1!=null && refContact1!=null && refName2!=null && refContact2!=null;
					if(isNotNull){
						boolean isEmpty = employerName.trim().isEmpty() && designation.trim().isEmpty() && strDurationFrom.trim().isEmpty() 
								&& strDurationTill.trim().isEmpty()	&& strIndustryId.trim().isEmpty() && strIndustrySectorId.trim().isEmpty() 
								&& strCtcFixed.trim().isEmpty() && strCtcvariable.trim().isEmpty()
								&& refName1.trim().isEmpty() && refContact1.trim().isEmpty() && refName2.trim().isEmpty() && refContact2.trim().isEmpty();  
						
						if(!isEmpty){
							try{
								ExperienceDetails ed = new ExperienceDetails();
								ed.setEmployerName(employerName);
								ed.setDesignation(designation);
								ed.setDurationFrom(DATE_FORMAT.parse(strDurationFrom));
								ed.setDurationTill(DATE_FORMAT.parse(strDurationFrom));
								IndustrySector industrySector =	industrySectorService.getById(Long.parseLong(strIndustrySectorId.trim()));
								IndustrySector temp = new IndustrySector();
								temp.setSectorId(industrySector.getSectorId());
								temp.setSectorName(industrySector.getSectorName());
								ed.setIndustrySector(temp);
								
								ed.setCtcFixed(Double.parseDouble(strCtcFixed.trim()));
								ed.setCtcVariable(Double.parseDouble(strCtcvariable.trim()));
								ed.setRefferenceName1(refName1);
								ed.setRefferenceContNo1(refContact1);
								ed.setRefferenceName2(refName2);
								ed.setRefferenceContNo2(refContact2);
								ed.setEmployee(employee);
								
								employee.getExperienceDetails().add(ed);
								//Session session = HibernateUtil.getSessionFactory().openSession();
								//session.beginTransaction();
								//session.save(ed);
								//session.getTransaction().commit();
								//session.close();
								flag = true;
							}catch(Exception e){
								System.out.println("2) Exception : getExperienceDetails() : "+e.getMessage());
							}
						}
					}
				}
				
			}
		}
		return flag;
	}
	
	
	private boolean setEducationalQualDetails(Employee employee, HttpServletRequest request){
		boolean flag = false;
		for(int i=1; i<=4; i++){
			String course = request.getParameter("course"+i);
			String schUni = request.getParameter("school-university"+i);
			String passYr = request.getParameter("passing-year"+i);
			String percent = request.getParameter("percent"+i);
			
			if(course!=null && schUni!=null && passYr!=null && percent!=null){
				if(!course.trim().isEmpty() && !schUni.trim().isEmpty() && !passYr.trim().isEmpty() && !percent.trim().isEmpty()){
					try{
						EducationalQualDetails eqd = new EducationalQualDetails();
						eqd.setCourseName(course);
						eqd.setSchoolUniversity(schUni);
						eqd.setPassingYear(DATE_FORMAT.parse(passYr));
						eqd.setPercentObtained(Double.parseDouble(percent.trim()));
						eqd.setEmployee(employee);
						
						employee.getEducationalQualDetails().add(eqd);
						flag = true;
					}catch(Exception e){
						System.out.println("Exception : getEducationalQualDetails() : "+e.getMessage());
					}
				}
			}
		}
	
		return flag;
	}
	
	
}
