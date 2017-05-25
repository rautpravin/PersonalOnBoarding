<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Add Employee</title>

    <!-- Bootstrap -->
    <link href="/personnel_on_boarding/res/css/bootstrap.min.css" rel="stylesheet">

	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<link href="/personnel_on_boarding/res/css/form.css" rel="stylesheet">
	
	
	<script src="/personnel_on_boarding/res/custom/js/emp_form.js"></script>
	<script src="/personnel_on_boarding/res/custom/js/empform_ajax.js"></script>
	  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-2 col-md-3 col-lg-3"></div>
			
			<form id="emp-form" onsubmit="return false;">
			<div class="col-sm-10 col-md-7 col-lg-6">
				<!-- Personal Details -->
				<div class="form-container" id="divPersonalDetails" style="display: block;" >
					<h3 class="form-title"> Personal Details</h3>
					<div class="form-group">
						<label>Employee Name</label>
						<div class="row">
							<div class="col-sm-4">
								<label>First Name</label>
								<input type="text" class="form-control" name="firstName" id="firstName" placeholder="firstName" />
							</div>	
							<div class="col-sm-4">
								<label>Middle Name</label>
								<input type="text" class="form-control" name="middleName" id="middleName" placeholder="middleName" />
							</div>	
							<div class="col-sm-4">
								<label>Last Name</label>
								<input type="text" class="form-control" name="lastName" id="lastName" placeholder="lastName" />
							</div>	
						</div>	
					</div>
												
					<div class="form-group">
						<label>Birth Date</label>
						<input type="date" name="birthDate" id="birthDate" class="form-control" />
					</div>
						
					<div class="form-group">
						<label>Gender</label>
						<select name="gender" id="gender" class="form-control" >
							<option value="male">male</option>
							<option value="female">female</option>
						</select>	
					</div>
					
					<div class="form-group">
						<label>Marital Status</label>
						<select class="form-control" name="maritalStatus" id="maritalStatus" >
						<option value="unmarried">unmarried</option>
						<option value="married">married</option>
						</select>
					</div>
						
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" id="btnPersonalDetails" onclick="showForm('divContactInformation')" >Next-></button>
					</div>
				</div> <!-- Personal Details -->
				
				<!-- Contact Information -->
				<div class="form-container" id="divContactInformation" style="display: none;">
					<h3 class="form-title">Contact Information</h3>	
					<div class="form-group">
						<label>Email Id </label>
						<input type="text" class="form-control" name="emailId" id="emailId" placeholder="email-id"  />	
					</div>
			
					<div class="form-group">
						<label>Mobile No</label>
						<span class="input-group">
						<span class="input-group-addon" style="padding: 0px;">
						<select name="mobExtNo" name="mobileExtNo" id="mobileExtNo">
						<option value="+91">+91</option>
						</select>
						</span>
						<input type="text" class="form-control" name="mobileNo" id="moblieNo" placeholder="mobileNo" maxlength="10" />
						</span>
					</div>
					
					<div class="form-group">
						<label>Landline No</label>
						<input type="text" class="form-control" name="landlineNo" id="landlineNo" placeholder="landlineNo" />
					</div>
				
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('divPersonalDetails')" id="btnContInfoBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divEmergencyContactDetails')" id="btnContInfoNext">Next</button>
					</div>					
				</div><!-- Contact Information -->
				
				
				<!-- Emergency Contact Details -->
				<div class="form-container" id="divEmergencyContactDetails" style="display: none;">
					<h3 class="form-title">Emergency Contact Details</h3>
					
					<div class="form-group">
						<label>Person Name</label>
						<input type="text" class="form-control" name="emergencyContactPersonName" id="emergencyContactPersonName" placeholder="contactPersonName"  />
					</div>
					
					<div class="form-group">
						<label>Contact No</label>
						<input type="text" class="form-control" name="emergencyContactNo" id="emergencyContactNo" placeholder="contactPersonName"  />
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('divContactInformation')" id="btnEmergencyContBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divAddressDetails')" id="btnEmergencyContNext">Next</button>
					</div>
				</div><!-- Emergency Contact Details -->
				
				
				<!-- Address Details -->
				<div class="form-container" id="divAddressDetails" style="display: none;">
					<h3 class="form-title">Address Details</h3>
					<div class="form-group">
					<label>Flat/Building No</label>
					<input type="text" class="form-control" name="flatBuildingNo" id="flatBuildingNo" placeholder="buliding/flat no"  />
					</div>
					
					<div class="form-group">
					<label>Street Lane 1</label>
					<input type="text" class="form-control" name="streetLane1" id="streetLane1" placeholder="street lane 1"/>
					</div>
					
					<div class="form-group">
					<label>Street Lane 2</label>
					<input type="text" class="form-control" name="streetLane2" id="streetLane2" placeholder="street lane 2"  />
					</div>
					
					<div class="form-group">
					<label>Landmark</label>
					<input type="text" class="form-control" name="landmark" id="landmark" placeholder="landmark" />
					</div>
					
					<div class="form-group">
					<label>Location</label>
					<input type="text" class="form-control" name="location" id="location" placeholder="location" />
					</div>
					
					<div class="form-group">
					<label>Country</label>
					<select name="country" id="country" class="form-control" onchange="loadStates(this)">
					<option></option>
					<option value="india">India</option>
					</select>
					</div>
					
					<div class="form-group">
					<label>State</label>
					<select name="state" id="state" class="form-control" onchange="loadCities(this)">
					<option></option>
					</select>
					</div>
					
					<div class="form-group">
					<label>City</label>
					<select name="city" id="city" class="form-control" >
					<option></option>
					</select>
					</div>
					
					<div class="form-group">
					<label>Pincode</label>
					<input type="text" class="form-control" name="pincode" id="pincode" placeholder="pincode" />
					</div>
				
					<div class="form-group">
						<label>Address Proof</label>
						<select class="form-control" onchange="addrProofType()" name="addressProof" id="addressProof" >
						<option value="driving license">Driving License</option>
						<option value="voter id">Voter Id</option> 
						<option value="adhaar">Aadhaar</option> 
						<option value="passport">Passport</option>
						<option value="others">Others</option>
						</select>
					</div>
				
					<div class="form-group" id="otherAddrProofDetails" style="display: none;">
						<label>Address Proof Details</label>
						<input type="text" class="form-control" name="otherAddressProofVal" /> 
					</div>
					
					<div class="form-group">
						<label>Proof Id No</label>
						<input type="text" class="form-control" name="proofIdNo" /> 
					</div>
					
					<div class="form-group" style="text-align:right;"> 
						<button class="btn btn-primary" onclick="showForm('divEmergencyContactDetails')" id="btnAddrDetailsBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divBankDetails')" id="btnAddrDetailsNext">Next</button>
					</div>
				</div><!-- Address Details -->
				
				
				<!-- Bank Details -->
				<div class="form-container" id="divBankDetails" style="display: none;">
					<h3 class="form-title">Bank Details</h3>	
					<div class="form-group">
						<label>Account Number </label>
						<input type="text" class="form-control" name="accountNumber" id="accountNumber" placeholder="Account Number"  />	
					</div>
					
					<div class="form-group">
						<label>Account Holder’s Name​</label>
						<input type="text" class="form-control" name="accountHoldersName" id="accountHoldersName" placeholder="Account Holder’s Name​"  />	
					</div>
					
					<div class="form-group">
						<label>Branch Name​</label>
						<input type="text" class="form-control" name="branchName" id="branchName" placeholder="Branch Name​"  />	
					</div>
					
					<div class="form-group">
						<label>A/C Type​</label>
						<select class="form-control" name="acType" id="acType"  >
						<option value="current">Current</option>
						<option value="savings">Savings</option>
						</select>	
					</div>
					
					<div class="form-group">
						<label>IFSC Code​</label>
						<input type="text" class="form-control" name="ifscCode" id="ifscCode" placeholder="IFSC Code​"  />	
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('divAddressDetails')" id="btnBankDetailsBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divEduQualDetails')" id="btnBankDetailsNext">Next</button>
					</div>
				
				</div><!-- Bank Details -->
				
				
				
				<!-- Education Qual Details -->
				<div class="form-container" id="divEduQualDetails" style="display: none;">
					<h3 class="form-title">Educational Qualification Details</h3>	
					<div class="table-responsive">
					<table class="table table-striped">
					 
					<tr>
						<th>Course</th>
						<th>School/University</th>
						<th>Passing Yr</th>
						<th>Percent</th>
					</tr>
					
					<tr><td colspan="4">10th or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course1" class="form-control"/></td>
					<td><input type="text" name="schoolUniversity1" class="form-control"/></td>
					<td><input type="date" name="passingYear1" class="form-control"/></td>
					<td><input type="text" name="percent1" class="form-control"/></td>
					</tr>
					 
					<tr><td colspan="4">12th or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course2" class="form-control"/></td>
					<td><input type="text" name="schoolUniversity2" class="form-control"/></td>
					<td><input type="date" id="datepicker" name="passingYear2" class="form-control"/></td>
					<td><input type="text" name="percent2" class="form-control"/></td>
					</tr>
					
					<tr><td colspan="4">Graduation or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course3" class="form-control"/></td>
					<td><input type="text" name="schoolUniversity3" class="form-control"/></td>
					<td><input type="date" name="passingYear3" class="form-control"/></td>
					<td><input type="text" name="percent3" class="form-control"/></td>
					</tr>
					
					<tr><td colspan="4">PG or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course4" class="form-control"/></td>
					<td><input type="text" name="schoolUniversity4" class="form-control"/></td>
					<td><input type="date" name="passingYear4" class="form-control"/></td>
					<td><input type="text" name="percent4" class="form-control"/></td>
					</tr>
					
					</table>
					</div>
					<div class="form-group" style="text-align: right;"> 
						<button class="btn btn-primary" onclick="showForm('divBankDetails')" id="btnEduQualDetailsBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divExperienceDetails')" id="btnEduQualDetailsNext">Next</button>
					</div>
				
				</div><!-- Education Qual Details -->
				
				
				
				<!-- Experience Details -->
				<div class="form-container" id="divExperienceDetails" style="display: none;">
					<h3 class="form-title">Experience Details</h3>	
					
					<div class="form-group">
						<div class="col-sm-6">
							<input type="radio" checked="checked" name="experienceType" id="r1" value="fresher"  onclick="isExperienced()"/>&nbsp;Fresher
						</div>
						<div class="col-sm-6">
							<input type="radio" onselect="loadIndustries()" name="experienceType" id="r2" value="experienced"  onclick="isExperienced()"/>&nbsp;Experienced
						</div>
					</div>
					<br>
					<div id="subDivforExperienced" style="display: none;">
						<div class="form-container" style="display: block;">
							<h3 class="form-title">First Employer Details</h3>
							
							<div class="form-group">
							<label>Employer Name</label>
							<input type="text" name="employerName1" id="employerName1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Designation</label>
							<input type="text" name="designation1" id="designation1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Duration From</label>
							<input type="date" name="durationFrom1" id="durationFrom1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Duration Till</label>
							<input type="text" name="durationTill1" id="durationTill1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Industry</label>
							<select name="industry1" id="industry1" class="form-control">
							<option></option> 
							</select>
							</div>	
							
							<div class="form-group">
							<label>Total Experience</label>
							<input type="text" name="totalExperience1" id="totalExperience1" class="form-control" readonly="readonly"/> 
							</div>	
							
							<div class="form-group">
							<label>CTC Fixed</label>
							<input type="text" name="ctcFixed1" id="ctcFixed1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>CTC Variable</label>
							<input type="text" name="ctcVariable1" id="ctcVariable1" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>1st Reference Name</label>
							<input type="text" name="refName101" id="refName101" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>1st Reference Contact</label>
							<input type="text" name="refContact101" id="refContact101" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>2st Reference Name</label>
							<input type="text" name="refName102" id="refName102" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>2st Reference Contact</label>
							<input type="text" name="refContact102" id="refContact102" class="form-control" /> 
							</div>	
						
						</div>
					
						<div class="form-container"  style="display: block;">
							<h3 class="form-title">Second Employer Details</h3>
							
							<div class="form-group">
							<label>Employer Name</label>
							<input type="text" name="employerName2" id="employerName2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Designation</label>
							<input type="text" name="designation2" id="designation2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Duration From</label>
							<input type="date" name="durationFrom2" id="durationFrom2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Duration Till</label>
							<input type="text" name="durationTill2" id="durationTill2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>Industry</label>
							<select name="industry2" id="industry2" class="form-control">
							<option></option> 
							</select>
							</div>	
							
							<div class="form-group">
							<label>Total Experience</label>
							<input type="text" name="totalExperience2" id="totalExperience2" class="form-control" readonly="readonly"/> 
							</div>	
							
							<div class="form-group">
							<label>CTC Fixed</label>
							<input type="text" name="ctcFixed2" id="ctcFixed2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>CTC Variable</label>
							<input type="text" name="ctcVariable2" id="ctcVariable2" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>1st Reference Name</label>
							<input type="text" name="refName201" id="refName201" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>1st Reference Contact</label>
							<input type="text" name="refContact201" id="refContact201" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>2st Reference Name</label>
							<input type="text" name="refName202" id="refName202" class="form-control" /> 
							</div>	
							
							<div class="form-group">
							<label>2st Reference Contact</label>
							<input type="text" name="refContact202" id="refContact202" class="form-control" /> 
							</div>				
						</div>
					
						<div class="form-container" style="display: block;">
							<h3 class="form-title">Previous Employment and experience</h3>
							<div class="form-group">
							<label>Total Years Of Experience</label>
							<input type="text" name="preTotExp" id="preTotExp"  class="form-control" />
							</div>
						</div>
					
						<div class="form-container" style="display: block;">
							<h3 class="form-title">Grand Total work experience</h3>
							<input type="text" id="grandTotWorkExp" name="grandTotWorkExp" readonly="readonly" class="form-control" /> 
						</div>
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('divEduQualDetails')" id="btnExpDetailsBack">Back</button>
						<button class="btn btn-primary" onclick="showForm('divEmploymentDetails')" id="btnExpDetailsNext">Next</button>
					</div>
				</div><!-- Experience Details -->
				
						
						
				<!-- Employment Details -->
				<div class="form-container" id="divEmploymentDetails" style="display: none;">
					<h3 class="form-title">Employment details</h3>
					<div class="form-group">
						<label>Joining Date</label>
						<input type="date" class="form-control" name="joiningDate"/>
					</div>
					
					<div class="form-group">
						<label>Leaving Date</label>
						<input type="date" class="form-control" name="leavingDate"/>
					</div>
					
					<div class="form-group">
						<label>Designation</label>
						<select class="form-control" name="designation">
						
						</select>
					</div>
					
					<div class="form-group">
						<label>Allocation City</label>
						<select name="allocationCity" class="form-control"></select>
					</div>
					
					<div class="form-group">
						<label>Assigned Industry</label>
						<select class="form-control" name="assignedIndustry">
						
						</select>
					</div>
					
					<div class="form-group">
						<label>Assigned Sector</label>
						<select name="assignedSector" class="form-control"></select>
					</div>
					
					<div class="form-group">
						<label>Reporting Manager</label>
						<input type="text" name="reportingManager" class="form-control" />
					</div>
					
					<div class="form-group">
						<label>CTC</label>
						<input type="text" name="ctc" class="form-control" />
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('divExperienceDetails')" id="btnEmploymentDetailsBack">Back</button>
						<button class="btn btn-primary" onclick="addRec()" id="btnEmploymentDetailsNext">Submit</button>
					</div>
				</div><!-- Employment Details -->
						
				<h4 id="errMsg" style="text-align: center; color: orange; font-style: italic; margin-top:-8px; background: black;"></h4>
			</div><!-- end of parent col -->
			</form>
			
			
			<div class="col-sm-2 col-md-2 col-lg-3"></div>
		</div>
	</div>

	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/personnel_on_boarding/res/js/bootstrap.min.js"></script>
    
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	$( function() {
		$( "#datepicker" ).datepicker();
	} );
	</script>
	<script type="text/javascript">
	function addrProofType(){
		if(document.getElementById("addressProof").value==="others")
			document.getElementById("otherAddrProofDetails").style.display="block";
		else
			document.getElementById("otherAddrProofDetails").style.display="none";
	}
	
	function isExperienced(){
		var radios = document.getElementsByName("experienceType");
		var val = "";
		for (var i = 0, length = radios.length; i < length; i++) {
		    if (radios[i].checked) {
		        val = radios[i].value; 
		        break;
		    }
		}
		 
		if(val==="experienced"){
	        	document.getElementById("subDivforExperienced").style.display="block";
		}else{
	        	document.getElementById("subDivforExperienced").style.display="none";
		}
	}
	</script>
</body>
</html>