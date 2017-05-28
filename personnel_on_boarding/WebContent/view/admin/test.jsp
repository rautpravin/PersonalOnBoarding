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
			
			<div class="col-sm-10 col-md-7 col-lg-6" id="forms-container">
				
				<!-- Personal Details -->
				<form id="div-personal-details" onsubmit="return false;" >
					<hr>
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;"> Personal Details</h3>
					
					<div class="form-group">
						<label>Employee Name</label>
						<div class="row">
							<div class="col-sm-4">
								<label>First Name *</label>
								<input type="text" class="form-control manditory" name="first-name" id="first-name" placeholder="First Name" />
							</div>	
							<div class="col-sm-4">
								<label>Middle Name *</label>
								<input type="text" class="form-control manditory" name="middle-name" id="middle-name" placeholder="Middle Name" />
							</div>	
							<div class="col-sm-4">
								<label>Last Name *</label>
								<input type="text" class="form-control manditory" name="last-name" id="last-name" placeholder="Last Name" />
							</div>	
						</div>	
					</div>
												
					<div class="form-group">
						<label>Birth Date *</label>
						<input type="text" class="form-control manditory" name="birth-date" id="birth-date" />
					</div>
						
					<div class="form-group">
						<label>Gender *</label>
						<select name="gender" class="form-control manditory" id="gender" >
							<option></option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select>	
					</div>
					
					<div class="form-group">
						<label>Marital Status *</label>
						<select class="form-control manditory" name="marital-status" id="marital-status" >
						<option></option>
						<option value="unmarried">unmarried</option>
						<option value="married">married</option>
						</select>
					</div>
							
					<div class="form-group" style="text-align: right;">
						<button onclick="next('div-personal-details', 'div-contact-details')">check it!</button>
						<button class="btn btn-primary" id="btn-personal-details" onclick="showForm('div-personal-details', 'div-contact-information')" >Next-></button>
					</div>
					<hr>
				</form> <!-- Personal Details -->
			
				<!-- Contact Details -->
				<form id="div-contact-details" onsubmit="return false;">
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Contact Details</h3>
					<div class="form-group">
						<label>Email Id *</label>
						<input type="text" class="form-control manditory" name="email-id" id="email-id"/>
					</div>	
					
					<div class="form-group">
						<label>Mobile No *</label>
						<span class="input-group">
						<span class="input-group-addon" style="padding: 0px;">
						<select class="form-control manditory " name="mobile-ext-no" id="mobile-ext-no" style="width: 100px;">
						<option></option>
						<option value="+91">+91</option>
						</select>
						</span>
						<input type="text" class="form-control manditory " name="mobile-no" id="moblie-no" placeholder="Mobile No" maxlength="10" />
						</span>
					</div>
					
					<div class="form-group">
						<label>Landline No</label>
						<input type="text" class="form-control" name="landline-no" id="landline-no" placeholder="landline-no" />
					</div>
					<hr>
					<div class="form-group">
						<label>Emergency Cont. Person Name *</label>
						<input type="text" class="form-control manditory" name="emergency-contact-person-name" id="emergency-contact-person-name" placeholder="Emergency Cont. Person"  />
					</div>
					
					<div class="form-group">
						<label>Emergency Cont. No *</label>
						<input type="text" class="form-control manditory" name="emergency-contact-no" id="emergency-contact-no" placeholder="Emergency Cont. No."  />
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button onclick="next('div-contact-details', 'div-address-details')">check it!</button>
						<button class="btn btn-primary" onclick="showForm('div-contact-details','div-contact-information')" id="btn-emergency-cont-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-contact-details','div-address-details')" id="btn-emergency-cont-next">Next</button>
					</div>
					<hr>
				</form><!-- Contact Details -->
				
				<!-- Address Details -->
				<form id="div-address-details" onsubmit="return false;">
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Address Details</h3>
					<div class="form-group">
					<label>Flat/Building No *</label>
					<input type="text" class="form-control manditory" name="flat-building-no" id="flat-building-no" placeholder="Buliding/Flat no"  />
					</div>
					
					<div class="form-group">
					<label>Street Lane 1</label>
					<input type="text" class="form-control" name="street-lane1" id="street-lane1" placeholder="Street Lane 1"/>
					</div>
					
					<div class="form-group">
					<label>Street Lane 2 *</label>
					<input type="text" class="form-control manditory" name="street-lane2" id="street-lane2" placeholder="Street Lane 2"  />
					</div>
					
					<div class="form-group">
					<label>Landmark *</label>
					<input type="text" class="form-control manditory" name="landmark" id="landmark" placeholder="Landmark" />
					</div>
					
					<div class="form-group">
					<label>Location *</label>
					<input type="text" class="form-control manditory" name="location" id="location" placeholder="Location" />
					</div>
					
					<div class="form-group">
					<label>Country *</label>
					<select name="country" id="countries" class="form-control manditory" onchange="loadStates(this)">
					<option></option>
					</select>
					</div>
					
					<div class="form-group">
					<label>State *</label>
					<select name="state" id="states" class="form-control manditory" onchange="loadCities(this)">
					<option></option>
					</select>
					</div>
					
					<div class="form-group">
					<label>City *</label>
					<select name="city" id="cities" class="form-control manditory" >
					<option></option>
					</select>
					</div>
					
					<div class="form-group">
					<label>Pincode *</label>
					<input type="text" class="form-control manditory" name="pincode" id="pincode" placeholder="Pincode" />
					</div>
				
					<div class="form-group">
						<label>Address Proof *</label>
						<select class="form-control manditory" onchange="addrProofType()" name="address-proof" id="address-proof" >
						<option value="Driving License">Driving License</option>
						<option value="Voter Id">Voter Id</option> 
						<option value="Aadhaar">Aadhaar</option> 
						<option value="Passport">Passport</option>
						<option value="Others">Others</option>
						</select>
					</div>
					
					<div class="form-group" id="other-addrProof-details" style="display: none;">
						<label>Address Proof Details *</label>
						<input type="text" class="form-control" name="other-address-proof-name" id="other-address-proof-name" /> 
					</div>
					
					<div class="form-group">
						<label>Proof Id No *</label>
						<input type="text" class="form-control manditory" name="proof-id-no" id="proof-id-no" /> 
					</div>
					
					<div class="form-group" style="text-align:right;">
						<button onclick="next('div-address-details', 'div-bank-details')">check it!</button>
						<button class="btn btn-primary" onclick="showForm('div-address-details', 'div-emergency-contact-details')" id="btn-addr-details=-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-address-details', 'div-bank-details')" id="btn-addr-details-next">Next</button>
					</div>
					<hr>
				</form><!-- Address Details -->
				
				
				<!-- Bank Details -->
				<form id="div-bank-details" onsubmit="return false">
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Bank Details</h3>
					<div class="form-group">
						<label>Account Number *</label>
						<input type="text" class="form-control manditory" name="account-number" id="account-number" placeholder="Account Number"  />	
					</div>
					
					<div class="form-group">
						<label>Account Holder’s Name​ *</label>
						<input type="text" class="form-control manditory" name="account-holders-name" id="account-holders-name" placeholder="Account Holder’s Name​"  />	
					</div>
					
					<div class="form-group">
						<label>Branch Name​ *</label>
						<input type="text" class="form-control manditory" name="branch-name" id="branch-name" placeholder="Branch Name​"  />	
					</div>
					
					<div class="form-group">
						<label>A/C Type *​</label>
						<select class="form-control manditory" name="account-type" id="account-type"  >
						<option value="Current">Current</option>
						<option value="Savings">Savings</option>
						</select>	
					</div>
					
					<div class="form-group">
						<label>IFSC Code *​</label>
						<input type="text" class="form-control manditory" name="ifsc-code" id="ifsc-code" placeholder="IFSC Code​"  />	
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button onclick="next('div-bank-details', 'div-equ-qual-details')">check it!</button> 
						<button class="btn btn-primary" onclick="showForm('div-bank-details', 'div-address-details')" id="btn-bank-details-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-bank-details', 'div-edu-qual-details')" id="btn-bank-details-next">Next</button>
					</div>
					<hr>
				</form><!-- Bank Details -->
				
				<!-- Education Qual Details -->
				<form id="div-edu-qual-details" onsubmit="return false;">	
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Educational Qualification Details</h3>
					
					<div class="table-responsive">
					<table class="table table-striped">
					 
					<tr>
						<th >Course</th>
						<th >School/University</th>
						<th >Passing Yr</th>
						<th >Percent</th>
					</tr>
					
					<tr><td colspan="4">10th or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course1" id="course1" class="form-control"/></td>
					<td><input type="text" name="school-university1" id="school-university1" class="form-control"/></td>
					<td><input type="text" name="passing-year1" id="passing-year1" class="form-control"/></td>
					<td><input type="text" name="percent1" id="percent1" class="form-control"/></td>
					</tr>
					 
					<tr><td colspan="4">12th or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course2" id="course2" class="form-control"/></td>
					<td><input type="text" name="school-university2" id="school-university2" class="form-control"/></td>
					<td><input type="text" name="passing-year2" id="passing-year2" class="form-control"/></td>
					<td><input type="text" name="percent2" id="percent2" class="form-control"/></td>
					</tr>
					
					<tr><td colspan="4">Graduation or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course3" id="course3" class="form-control"/></td>
					<td><input type="text" name="school-university3" id="school-university3" class="form-control"/></td>
					<td><input type="text" name="passing-year3" id="passing-year3" class="form-control"/></td>
					<td><input type="text" name="percent3" id="percent3" class="form-control"/></td>
					</tr>
					
					<tr><td colspan="4">PG or Equivalent</td></tr>
					<tr>
					<td><input type="text" name="course4" id="course4" class="form-control"/></td>
					<td><input type="text" name="school-university4" id="school-university4" class="form-control"/></td>
					<td><input type="text" name="passing-year4" id="passing-year4" class="form-control"/></td>
					<td><input type="text" name="percent4" id="percent4" class="form-control"/></td>
					</tr>
					
					</table>
					</div>
					<div class="form-group" style="text-align: right;"> 
						<button onclick="next('div-edu-qual-details', 'div-experience-details')">check it!</button>
						<button class="btn btn-primary" onclick="showForm('div-edu-qual-details', 'div-bank-details')" id="btn-edu-qual-details-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-edu-qual-details', 'div-experience-details')" id="btn-eduQual-details-next">Next</button>
					</div>
				
				</form><!-- Education Qual Details -->
				
				
				<!-- Experience Type Details -->
				<form id="div-experience-details" onsubmit="return false;">
					<h3 class="form-title">Experience Details</h3>	
					<div class="form-group">
					<label>Experience Type *</label>
					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<input type="radio" onclick="document.getElementById('div-for-experienced').style.display = 'none';" checked="checked" name="experience-type" id="fresher" value="fresher" />&nbsp;Fresher
						</div>
						<div class="col-sm-6">
							<input type="radio" onclick="document.getElementById('div-for-experienced').style.display = 'block';" name="experience-type" id="experienced" value="experienced" />&nbsp;Experienced
						</div>
					</div>
					<div class="form-group" style="text-align: right;">	
						<button onclick="next('div-experience-details', 'div-employment-details')">check it!</button>	
						<button class="btn btn-primary" onclick="showForm('div-experience-details', 'div-edu-qual-details')" id="btn-exp-details-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-experience-details', 'div-employment-details')" id="btn-exp-details-next">Next</button>
					</div>
				</form><!-- Experience Type Details -->
				
				<!-- Experience Details -->
				<form id="div-for-experienced" onsubmit="return false;" style="display: none;">
					<h3 class="form-title">Employer Details</h3>
					<h5 id="exp-added" style="text-align: right;">Total previous exp added : 0</h5>		
					<div class="form-group">
						<label>Employer Name</label>
						<input type="text" name="employer-name" id="employer-name" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>Designation</label>
						<input type="text" name="designation" id="designation" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>Duration From</label>
						<input type="text" name="duration-from" id="duration-from" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>Duration Till</label>
						<input type="text" name="duration-till" id="duration-till" class="form-control" /> 
					</div>	
						
					<div class="form-group">
						<label>Industry</label>
						<select name="industries" id="industries" class="form-control">
						<option>test</option>
						</select>
					</div>	
							
					<div class="form-group">
						<label>Total Experience</label>
						<input type="text" name="total-experience" id="total-experience" class="form-control" /> 
					</div>	
						
					<div class="form-group">
						<label>CTC Fixed</label>
						<input type="text" name="ctc-fixed1" id="ctc-fixed" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>CTC Variable</label>
						<input type="text" name="ctc-variable" id="ctc-variable" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>1st Reference Name</label>
						<input type="text" name="ref-name1" id="ref-name1" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>1st Reference Contact</label>
						<input type="text" name="ref-contact1" id="ref-contact1" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>2st Reference Name</label>
						<input type="text" name="ref-name2" id="ref-name2" class="form-control" /> 
					</div>	
						
					<div class="form-group">
						<label>2st Reference Contact</label>
						<input type="text" name="ref-contact2" id="ref-contact2" class="form-control" /> 
					</div>	
					
					<div class="form-group" style="text-align: right;">
						<button onclick="saveExp()" class="btn btn-success">Save (AddMore(+))</button>
					</div>
				</form> <!-- for experience details -->	
				
				
				
				<!-- Employment Details -->
				<form id="div-employment-details" onsubmit="return false;">
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Employment Details</h3>
					<div class="form-group">
						<label>Joining Date *</label>
						<input type="text" class="form-control manditory" name="joining-date" id="joining-date"/>
					</div>
					
					<div class="form-group">
						<label>Leaving Date *</label>
						<input type="text" class="form-control manditory" name="leaving-date" id="leaving-date" />
					</div>
					
					<div class="form-group">
						<label>Designation *</label>
						<select class="form-control manditory" name="designations" id="designations"> </select>
					</div>
					
					<div class="form-group">
						<label>Allocation City *</label>
						<select name="allocation-city" id="allocation-city" class="form-control manditory"> </select>
					</div>
					
					<div class="form-group">
						<label>Assigned Industry *</label>
						<select class="form-control manditory" onchange="loadIndustrySectors(this)" name="assigned-industry" id="assigned-industry"> </select>
					</div>
					
					<div class="form-group">
						<label>Assigned Sector *</label>
						<select name="assigned-sector" id="assigned-sector" class="form-control manditory"> </select>
					</div>
					
					<div class="form-group">
						<label>Reporting Manager *</label>
						<input type="text" name="reporting-manager" id="reporting-manager" class="form-control manditory" />
					</div>
					
					<div class="form-group">
						<label>CTC</label>
						<input type="text" name="ctc" id="ctc" class="form-control manditory" />
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="showForm('div-employment-details', 'div-experience-details')" id="btn-employment-details-back">Back</button>
						<button class="btn btn-primary" onclick="showForm('div-employment-details', 'div-submit-details')" id="btn-employment-details-next">Submit</button>
					</div>
					<hr>
				</form><!-- Employment Details -->

					
				
				
			</div>
			
			<div class="col-sm-2 col-md-3 col-lg-3"></div>
		</div>
	</div>				
				
	<script>
	
	window.onload = function(){
		document.getElementById("div-personal-details").style.display = "block";
		document.getElementById("div-contact-details").style.display = "none";
		document.getElementById("div-address-details").style.display = "none";
		document.getElementById("div-bank-details").style.display = "none";
		document.getElementById("div-edu-qual-details").style.display = "none";
		document.getElementById("div-employment-details").style.display = "none";
		document.getElementById("div-experience-details").style.display = "none";
		document.getElementById("div-for-experienced").style.display = "none";
	}
	
	
	function next(curr,next){
		var elements = document.getElementById(curr).elements;
		var f = true;
		for(i=0;i<elements.length;i++){
			var c = elements[i].className.split(" ");
			for(j=0;j<c.length;j++){
				if(c[j]==="manditory"){
					if(elements[i].value.trim()===""){
						f = false;
						break;
					}
				}
			}
			
		}
		if(!f){
			alert("all * fields are manditory!");
		}else{
			if(document.getElementById(curr).id==="div-experience-details")
				document.getElementById("div-for-experienced").style.display = "none";
			
			document.getElementById(curr).style.display = "none";
			document.getElementById(next).style.display = "block";	
		}
	}
	
	
	function getParams(){
		var allparams = "";
		var forms = document.getElementById("forms-container").getElementsByTagName('form');
		for(i=0;i<forms.length;i++){
			if(forms[i].id!=="div-for-experienced" || forms[i].id!=="div-edu-qual-details"){
				var elements = forms[i].elements;
				for(j=0; j<elements.length; j++){
					if(elements[j].tagName==="SELECT" || elements[j].tagName==="INPUT"){
						allparams += elements[j].id+"="+elements[j].value+"&";		
					}
				}
			}
		}
		var edu = eduQual();
		if(edu!=="")
			allparams+=edu;
		if(allExp!=="")
			allparams+="&"+allExp+"&all-exp-no="+allExpNo;
		
		alert("all params : "+allparams);
	}
	
	
	//--------------------------------------------------
	var allExp = "";
	var allExpNo = 0;
	var n = 1;
	function saveExp(){
		var f = false;
		var temp = "";
		var elements = document.getElementById("div-for-experienced");
		for(i=0;i<elements.length;i++){
			var ele = elements[i];
			if(ele.tagName==="INPUT" || ele.tagName==="SELECT"){
				if(ele.value===""){
					alert("all values are manditory!");
					f = false;
					break;
				}else{
					temp += ele.id+""+n+"="+ele.value+"&";
					f = true;
				}
				
			}
				
		}
		if(f){
			f = false;
			allExp += temp;
			n++;
			allExpNo++;
			document.getElementById("exp-added").innerHTML = "Total previous exp added : "+allExpNo;
			document.getElementById("div-for-experienced").reset();
			document.getElementById("employer-name").focus();
		}
		
	}
	


	function eduQual(){
		var temp = "";
		var elements = document.getElementById("div-edu-qual-details").elements;
	
		for(i=1;i<=4;i++){
			var course = ""+ document.getElementById("course"+i).value;
			var schUni = ""+ document.getElementById("school-university"+i).value;
			var passYr = ""+ document.getElementById("passing-year"+i).value;
			var percent= ""+ document.getElementById("percent"+i).value;
			if(course.trim()!=="" && schUni.trim()!=="" && passYr.trim()!=="" && percent.trim()!==""){
				temp += "course"+i+"="+course+"&school-university"+i+"="+schUni+"&passing-year"+i+"="+passYr+"&percent"+i+"="+percent+"&";
			}
		}
		
		if(temp!=="")
			return temp.substring(0, temp.length-1);
		else
			return "";
	}	
	
	//------------------------------------------------------
	</script>			
</body>
</html>