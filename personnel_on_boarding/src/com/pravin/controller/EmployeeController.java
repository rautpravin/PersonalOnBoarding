package com.pravin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pravin.model.BankDetails;
import com.pravin.model.EducationalQualDetails;
import com.pravin.model.Employee;
import com.pravin.model.ExperienceDetails;
import com.pravin.service.EmployeeService;
import com.pravin.serviceImpl.EmployeeServiceImpl;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action")+"";
		
		switch (action) {
		case "add": 
			try {
				Employee e = getEmployee(request, response);
				e.setEmployeeId(employeeService.generateEmpId());
				String msg = employeeService.add(e);
				out.println("alert('"+msg+"')");
				
				response.sendRedirect("");
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("alert('"+e.getMessage()+"')");
				response.sendRedirect("");
			}
			break;

		case "get-states":
			String c = request.getParameter("country")+"";
			if(c.equalsIgnoreCase("india")){
				out.println("1,maharashtra;2,karnatak;3,kerala");
			}
			break;
			
		case "get-cities":
			String state = request.getParameter("state")+"".trim();
			switch(state){
			case "1":
				out.print("1,Akola;2,Pune;3,Washim;4,Mumbai");
				break;
			case "2":
				out.print("1, Banglore;2,Kar2;3,Kar3");
				break;
				
			case "3":
				out.print("1,kerC1;2,KerC2;3,KerC3");
				break;
			}
				
			break;
		default:
			break;
		}
	}
	
	
	private Employee getEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String, String[]> params = request.getParameterMap();
		
		//here manditory fields logic
		
		Employee employee = new Employee();
		{
			
			String firstName = params.get("firstName")[0];
			String middleName = params.get("middleName")[0];
			String lastName = params.get("lastName")[0];
			employee.setEmployeeName(firstName+" "+middleName+" "+lastName);
			
			String birthDate = params.get("birthDate")[0];
			employee.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(birthDate));
			
			String gender  = params.get("gender")[0];
			employee.setGender(gender);
			
			String maritalStatus  = params.get("maritalStatus")[0];
			employee.setMaritalStatus(maritalStatus);
			
			String emailId  = params.get("emailId")[0];
			employee.setEmailId(emailId);
			
			String mobExtNo  = params.get("mobExtNo")[0];
			String mobileNo  = params.get("mobileNo")[0];
			employee.setMobileNo(mobExtNo+""+mobileNo);
			
			String landlineNo  = params.get("landlineNo")[0];
			employee.setLandlineNo(landlineNo);
			
			String emergencyContactPersonName  = params.get("emergencyContactPersonName")[0];
			employee.setEmergencyContactPersonName(emergencyContactPersonName);
			
			String emergencyContactNo = params.get("emergencyContactNo")[0];
			employee.setEmergencyContactNo(emergencyContactNo);
			
			String flatBuildingNo  = params.get("flatBuildingNo")[0];
			employee.setFlatBuildingNo(flatBuildingNo);
			
			String streetLane1 = params.get("streetLane1")[0];
			employee.setStreetLane1(streetLane1);
			
			String streetLane2 = params.get("streetLane2")[0];
			employee.setStreetLane2(streetLane2);
			
			String landmark  = params.get("landmark")[0];
			employee.setLandmark(landmark);
			
			String location  = params.get("location")[0];
			employee.setLocation(location);
			
			String state  = params.get("state")[0];
			
			String city   = params.get("city")[0];
			
			String pincode = params.get("pincode")[0];
			employee.setPincode(pincode);
			
			String addressProof  = params.get("addressProof")[0];
			employee.setAddrProofDocType(addressProof);
			
			String otherAddressProofVal  = params.get("otherAddressProofVal")[0];
			employee.setOtherAddrProofType(otherAddressProofVal);

			String proofIdNo = params.get("proofIdNo")[0];
			employee.setAddrProofDocId(proofIdNo);

			
			String experienceType = params.get("experienceType")[0];
			employee.setExperienceType(experienceType);
			
			String preTotExp  = params.get("preTotExp")[0];
			if(preTotExp!=null)
				if(!preTotExp.trim().isEmpty())
					employee.setPreviousTotalYearsOfExp(Double.parseDouble(preTotExp));
			
			String grandTotWorkExp   = params.get("grandTotWorkExp")[0];
			String joiningDate  = params.get("joiningDate")[0];
			employee.setJoiningDate(new SimpleDateFormat("dd-MM-yyyy").parse(joiningDate));
			
			String leavingDate   = params.get("leavingDate")[0];
			employee.setLeavingDate(new SimpleDateFormat("dd-MM-yyyy").parse(leavingDate));
			
			String reportingManager = params.get("reportingManager")[0];
			//Employee manager = //getBy manager ID;
			//employee.setManager(manager);
			String ctc  = params.get("ctc")[0];
			employee.setCtc(Double.parseDouble(ctc));
			
			
			if(experienceType.equals("experienced")){
					
				//Experience Details
				ExperienceDetails experienceDetails1 = new ExperienceDetails();
				
				String employerName1   = params.get("employerName1")[0];
				experienceDetails1.setEmployerName(employerName1);
				
				String designation1   = params.get("designation1")[0];
				experienceDetails1.setDesignation(designation1);
				
				String durationFrom1   = params.get("durationFrom1")[0];
				experienceDetails1.setDurationFrom(new SimpleDateFormat("dd-MM-yyyy").parse(durationFrom1));
				
				String durationTill1   = params.get("durationTill1")[0];
				experienceDetails1.setDurationTill(new SimpleDateFormat("dd-MM-yyyy").parse(durationTill1));
				
				String industry1  = params.get("industry1")[0];
				//IndustrySector industrySector = new IndustrySector();
				//set industry sector - get by id
				
				
				String totalExperience1  = params.get("totalExperience1")[0];
				
				String ctcFixed1  = params.get("ctcFixed1")[0];
				experienceDetails1.setCtcFixed(Double.parseDouble(ctcFixed1));
	
				String ctcVariable1  = params.get("ctcVariable1")[0];
				experienceDetails1.setCtcVariable(Double.parseDouble(ctcVariable1));
				
				String refName101  = params.get("refName101")[0];
				experienceDetails1.setRefferenceName1(refName101);
				
				String refContact101   = params.get("refContact101")[0];
				experienceDetails1.setRefferenceContNo1(refContact101);
				
				String refName102  = params.get("refName102")[0];
				experienceDetails1.setRefferenceName2(refName102);
				
				String refContact102   = params.get("refContact102")[0];
				experienceDetails1.setRefferenceContNo2(refContact102);
				
				experienceDetails1.setEmployee(employee);
				//save experienceDetails1
				
				//Experience Details 2
				ExperienceDetails experienceDetails2 = new ExperienceDetails();
				String employerName2   = params.get("employerName2")[0];
				experienceDetails2.setEmployerName(employerName2);
				
				String designation2   = params.get("designation2")[0];
				experienceDetails2.setDesignation(designation2);
				
				String durationFrom2   = params.get("durationFrom2")[0];
				experienceDetails2.setDurationFrom(new SimpleDateFormat("dd-MM-yyyy").parse(durationFrom2));
				
				String durationTill2   = params.get("durationTill2")[0];
				experienceDetails2.setDurationTill(new SimpleDateFormat("dd-MM-yyyy").parse(durationTill2));
				
				String industry2  = params.get("industry2")[0];
				//get IndustrySetor byId
				//experienceDetails2.setIndustrySector(industrySector);
				
				String totalExperience2   = params.get("totalExperience2")[0];
				
				String ctcFixed2  = params.get("ctcFixed2")[0];
				experienceDetails2.setCtcFixed(Double.parseDouble(ctcFixed2));
				
				String ctcVariable2   = params.get("ctcVariable2")[0];
				experienceDetails2.setCtcVariable(Double.parseDouble(ctcVariable2));
				
				String refName201  = params.get("refName201")[0];
				experienceDetails2.setRefferenceName1(refName201);
				
				String refContact201  = params.get("refContact201")[0];
				experienceDetails2.setRefferenceContNo1(refContact201);

				String refName202  = params.get("refName202")[0];
				experienceDetails1.setRefferenceName2(refName202);
				
				String refContact202   = params.get("refContact202")[0];
				experienceDetails2.setRefferenceContNo2(refContact202);
				
				experienceDetails2.setEmployee(employee);
				
				//save experienceDetails2
			}
			
			//bank details
			BankDetails bankDetails = new BankDetails();
			String accountNumber  = params.get("accountNumber")[0];
			bankDetails.setAcNo(accountNumber);
			
			String accountHoldersName = params.get("accountHoldersName")[0];
			bankDetails.setAcHolderName(accountHoldersName);
			
			String branchName = params.get("branchName")[0];
			bankDetails.setBranchName(branchName);
			
			String acType  = params.get("acType")[0];
			bankDetails.setAcType(acType);

			String ifscCode = params.get("ifscCode")[0];
			bankDetails.setIfscCode(ifscCode);
			
			bankDetails.setEmployee(employee);
			
			employee.setBankDetails(bankDetails);
			
			
			//EducationalQualificationDetails
			String course1  = params.get("course1")[0];
			String schoolUniversity1  = params.get("schoolUniversity1")[0];
			String passingYear1  = params.get("passingYear1")[0];
			String percent1  = params.get("percent1")[0];
			String course2  = params.get("course1")[0];
			String schoolUniversity2  = params.get("schoolUniversity2")[0];
			String passingYear2  = params.get("passingYear2")[0];
			String percent2  = params.get("percent2")[0];
			String course3  = params.get("course3")[0];
			String schoolUniversity3  = params.get("schoolUniversity3")[0];
			String passingYear3  = params.get("passingYear3")[0];
			String percent3  = params.get("percent3")[0];
			String course4  = params.get("course4")[0];
			String schoolUniversity4 = params.get("schoolUniversity4")[0];
			String passingYear4  = params.get("passingYear4")[0];
			String percent4  = params.get("percent4")[0];
			
			String arr[][] = new String[4][4];
			arr[0][0] = course1;
			arr[0][1] = schoolUniversity1;
			arr[0][2] = passingYear1;
			arr[0][3] = percent1;
			
			arr[1][0] = course2;
			arr[1][1] = schoolUniversity2;
			arr[1][2] = passingYear2;
			arr[1][3] = percent2;
			
			arr[2][0] = course3;
			arr[2][1] = schoolUniversity3;
			arr[2][2] = passingYear3;
			arr[2][3] = percent3;
			
			arr[3][0] = course4;
			arr[3][1] = schoolUniversity4;
			arr[3][2] = passingYear4;
			arr[3][3] = percent4;
			
			EducationalQualDetails qualDetails = new EducationalQualDetails();
			boolean flag2 = false;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if(!arr[i][j].isEmpty()){
						flag2 = true;
						break;
					}
				}
				if(flag2){
					qualDetails.setCourseName(arr[i][0]);
					qualDetails.setSchoolUniversity(arr[i][1]);
					//qualDetails.setPassingYear(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i][2]));
					//qualDetails.setPercentObtained(Double.parseDouble(arr[i][3].trim()));
					qualDetails.setEmployee(employee);
					employee.getEducationalQualDetails().add(qualDetails);
					
					//save qualDetails 
				}
				
			}
			
		}
		
		
		
		return employee;
		
	}

}
