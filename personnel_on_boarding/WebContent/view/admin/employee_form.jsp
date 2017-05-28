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
	
	<link href="/personnel_on_boarding/res/custom/css/form.css" rel="stylesheet">
	
	
	<script src="/personnel_on_boarding/res/custom/js/employee.js"></script>
	
	  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<jsp:include page="/view/admin/navbar.jsp" flush="true"/>
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
						<button class="btn btn-primary" id="btn-personal-details" onclick="next('div-personal-details', 'div-contact-details')" >Next-></button>
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
						<input type="text" class="form-control manditory " name="mobile-no" id="mobile-no" placeholder="Mobile No" maxlength="10" />
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
						<button class="btn btn-primary" onclick="previous('div-contact-details','div-personal-details')" id="btn-emergency-cont-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-contact-details','div-address-details')" id="btn-emergency-cont-next">Next</button>
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
						<select class="form-control manditory" onchange="checkAddrProofType(this)" name="address-proof" id="address-proof" >
						<option value="Driving License">Driving License</option>
						<option value="Voter Id">Voter Id</option> 
						<option value="Aadhaar">Aadhaar</option> 
						<option value="Passport">Passport</option>
						<option value="Others">Others</option>
						</select>
					</div>
					<script>
					function checkAddrProofType(sel){
						if(sel.value==="Others"){
							document.getElementById("other-addrProof-details").style.display = "block";
						}else{
							document.getElementById("other-addrProof-details").style.display = "none";
						}	
					}
					</script>
					
					<div class="form-group" id="other-addrProof-details" style="display: none;">
						<label>Address Proof Details *</label>
						<input type="text" class="form-control" name="other-address-proof-name" id="other-address-proof-name" /> 
					</div>
					
					<div class="form-group">
						<label>Proof Id No *</label>
						<input type="text" class="form-control manditory" name="proof-id-no" id="proof-id-no" /> 
					</div>
					
					<div class="form-group" style="text-align:right;">
						<button class="btn btn-primary" onclick="previous('div-address-details', 'div-contact-details')" id="btn-addr-details=-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-address-details', 'div-bank-details')" id="btn-addr-details-next">Next</button>
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
						<button class="btn btn-primary" onclick="previous('div-bank-details', 'div-address-details')" id="btn-bank-details-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-bank-details', 'div-edu-qual-details')" id="btn-bank-details-next">Next</button>
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
						<button class="btn btn-primary" onclick="previous('div-edu-qual-details', 'div-bank-details')" id="btn-edu-qual-details-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-edu-qual-details', 'div-experience-details')" id="btn-eduQual-details-next">Next</button>
					</div>
				
				</form><!-- Education Qual Details -->
				
				
				<!-- Experience Type Details -->
				<form id="div-experience-details" onsubmit="return false;">
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Experience Details</h3>	
					<div class="form-group">
					<label>Experience Type *</label>
					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<input type="radio" onclick="document.getElementById('div-for-experienced').style.display = 'none';" checked="checked" name="experiencetype" id="fresher" value="fresher" />&nbsp;Fresher
						</div>
						<div class="col-sm-6">
							<input type="radio" onclick="document.getElementById('div-for-experienced').style.display = 'block';" name="experiencetype" id="experienced" value="experienced" />&nbsp;Experienced
						</div>
					</div>
					<div class="form-group" style="text-align: right;">	
						<button class="btn btn-primary" onclick="previous('div-experience-details', 'div-edu-qual-details')" id="btn-exp-details-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-experience-details', 'div-employment-details')" id="btn-exp-details-next">Next</button>
					</div>
				</form><!-- Experience Type Details -->
				
				<!-- Experience Details -->
				<form id="div-for-experienced" onsubmit="return false;" style="display: none;">
					<hr>
					<h3 style="padding: 8px; margin-bottom: 20px; font-weight: bold; border-bottom: 1px solid black;">Employer Details</h3>
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
						<input type="text" onblur="calculateDuration()" name="duration-from" id="duration-from" class="form-control" /> 
					</div>	
							
					<div class="form-group">
						<label>Duration Till</label>
						<input type="text"  onblur="calculateDuration()" name="duration-till" id="duration-till" class="form-control" /> 
					</div>	
						
					<div class="form-group">
						<label>Industry</label>
						<select name="industries" id="industries" onchange="loadIndustrySectors(this)" class="form-control">
						<option>test</option>
						</select>
					</div>	
				
					<div class="form-group">
						<label>Assigned Sector *</label>
						<select name="sectors" id="sectors" class="form-control manditory"> </select>
					</div>
					
					<script>	
					function calculateDuration(){
					var date1 = new Date(""+document.getElementById("duration-from").value);
					var date2 = new Date(""+document.getElementById("duration-till").value);
				
						if(date1!=="" && date2!==""){
							var timeDiff = Math.abs(date2.getTime() - date1.getTime());
							var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
							document.getElementById("total-experience").value = diffDays +" days";
						}
					}
					</script>

					<div class="form-group">
						<label>Total Experience</label>
						<input type="text" name="total-experience" id="total-experience" class="form-control" readonly="readonly" /> 
					</div>	
						
					<div class="form-group">
						<label>CTC Fixed</label>
						<input type="text" name="ctc-fixed" id="ctc-fixed" class="form-control" /> 
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
						<label>He is Manager ?</label>
						<select name="is-manager" id="is-manager" onchange="isManager(this)" class="form-control manditory"> 
						<option></option><option value="Yes">Yes</option><option value="No">No</option>
						</select>
					</div>
					<script>function isManager(opt){
						if(opt.value==="No"){
							document.getElementById('assign-manager').style.display='block';
							document.getElementById('assign-manager').setAttribute("class","form-control manditory");
						}
						else {
							document.getElementById('assign-manager').style.display='none';
							document.getElementById('assign-manager').setAttribute("class","form-control");
						}
					}</script>
					<div class="form-group" id="assign-manager" style="display: none;">
						<label>Reporting Manager *</label>
						<select name="reporting-manager" id="reporting-manager">
						</select>
					</div>
					
					<div class="form-group">
						<label>CTC</label>
						<input type="text" name="ctc" id="ctc" class="form-control manditory" />
					</div>
					
					<div class="form-group" style="text-align: right;">
						<button class="btn btn-primary" onclick="previous('div-employment-details', 'div-experience-details')" id="btn-employment-details-back">Back</button>
						<button class="btn btn-primary" onclick="next('div-employment-details', 'div-submit-details')" id="btn-employment-details-next">Submit</button>
					</div>
					<hr>
				</form><!-- Employment Details -->

				<div id="div-submit-details" style="display: none;">
					<button class="btn btn-primary">Back</button>
					<button class="btn btn-success" onclick="save()">Send</button>
				</div>
				
			</div>
			
			<div class="col-sm-2 col-md-3 col-lg-3"></div>
		</div>
	</div>				


	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/personnel_on_boarding/res/js/bootstrap.min.js"></script>
    
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	
	$( function() {
		
		 $( "#birth-date" ).datepicker({
	            changeMonth: true,
	            changeYear: true,
	            yearRange: '-70:+0'
	        });
		
		$( "#passing-year1" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#passing-year2" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#passing-year3" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#passing-year4" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#joining-date" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#leaving-date" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
		
		$( "#duration-from" ).datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: '-70:+0'
        });
	
		$( "#duration-till" ).datepicker({
        	changeMonth: true,
        	changeYear: true,
        	yearRange: '-70:+0'
    	});
	
		
	} );
	</script>
	<script type="text/javascript">
	function addrProofType(){
		if(document.getElementById("address-proof").value==="Others"){
			document.getElementById("other-address-proof-name").className="form-control manditory";
			document.getElementById("other-addrProof-details").style.display="block";
		}
		else{
			document.getElementById("other-address-proof-name").className="form-control";
			document.getElementById("other-addrProof-details").style.display="none";
		}
	}
	
	function isExperienced(){
		var radios = document.getElementsByName("experience-type");
		var val = "";
		for (var i = 0, length = radios.length; i < length; i++) {
		    if (radios[i].checked) {
		        val = radios[i].value; 
		        break;
		    }
		}
		 
		if(val==="experienced"){
	        	document.getElementById("div-for-experienced").style.display="block";
		}else{
	        	document.getElementById("div-for-experienced").style.display="none";
		}
	}
	</script>
</body>
</html>