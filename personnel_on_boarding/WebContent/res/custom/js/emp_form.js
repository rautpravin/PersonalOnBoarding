
function showForm(divName){
	if(isPersonalDetailsFilled()){
		hideAll();
		document.getElementById(""+divName+"").style.display="block";
	}
	
	
}


function hideAll(){
	document.getElementById("divPersonalDetails").style.display="none";
	document.getElementById("divContactInformation").style.display="none";
	document.getElementById("divEmergencyContactDetails").style.display="none";
	document.getElementById("divAddressDetails").style.display="none";
	document.getElementById("divBankDetails").style.display="none";
	document.getElementById("divEduQualDetails").style.display="none";
	document.getElementById("divExperienceDetails").style.display="none";
	document.getElementById("divEmploymentDetails").style.display="none";
}

function isPersonalDetailsFilled(){
	var fn = document.getElementById("firstName").value;
	var mn = document.getElementById("middleName").value;
	var ln = document.getElementById("lastName").value;
	var bd = document.getElementById("birthDate").value;
	var g = document.getElementById("gender").value;
	var ms = document.getElementById("maritalStatus").value;
	
	
	if(fn==="" || mn==="" || ln==="" || bd==="" || g==="" || ms===""){
		document.getElementById("errMsg").innerHTML = "All fields are manditory!";
		return false;
	}
	else{
		document.getElementById("errMsg").innerHTML = "";
		return true;
	}
}

function isContactInfoFilled(){
	var eid = document.getElementById("emailId").value;
	var mnoext = document.getElementById("mobileExtNo").value;
	var mno = document.getElementById("mobileNo").value;
	var lno = document.getElementById("landlineNo").value;
	
	if(eid==="" || mnoext==="" || mno==="" || lno===""){
		alert("all fields are manditory!");
		return false;
	}else
		return true;
}


function isEmergencyContFilled(){
	var ecpn = document.getElementById("emergencyContactPersonName").value;
	var ecpc = document.getElementById("emergencyContactNo").value;
	
	if(ecpn==="" || ecpc===""){
		alert("all fields are manditory!");
		return false;
	}else
		return true;
	
}


function isAddressDetailsFilled(){
	var fbno = document.getElementById("flatBuildingNo").value;
	var str1 = document.getElementById("streetLane1").value;
	var str2 = document.getElementById("streetLane2").value;
	var lm = document.getElementById("landmark").value;
	var loc = document.getElementById("location").value;
	var st = document.getElementById("state").value;
	var ct = document.getElementById("city").value;
	var pin = document.getElementById("pincode").value;
	var adp = document.getElementById("addressProof").value;
	var pino = document.getElementById("proofIdNo").value;
	
	if(fbno==="" || str2==="" || lm==="" || loc==="" || st==="" || ct==="" || pin==="" || adp==="" || pino===""){
		alert("all fields are manditory!");
		return false;
	}else
		return false;
}


function isBankDetailsFilled(){
	var acno = document.getElementById("accountNo").value;
	var achn = document.getElementById("accountHoldersName").value;
	var brn = document.getElementById("branchName").value;
	var act = document.getElementById("branchName").value;
	var ifsc = document.getElementById("ifscCode").value;
	if(acno==="" || achn==="" || brn==="" || act==="" || ifsc===""){
		alert("all fields are manditory!");
		return false;
	}else{
		return true;
	}
}


function isEduQualDetailsFilled(){
	var co1 = document.getElementById("course1").value;
	var su1 = document.getElementById("schoolUniversity1").value;
	var py1 = document.getElementById("passingYear1").value;
	var pr1 = document.getElementById("percent1").value;
	
	var co2 = document.getElementById("course2").value;
	var su2 = document.getElementById("schoolUniversity2").value;
	var py2 = document.getElementById("passingYear2").value;
	var pr2 = document.getElementById("percent2").value;
	
	var co3 = document.getElementById("course3").value;
	var su3 = document.getElementById("schoolUniversity3").value;
	var py3 = document.getElementById("passingYear3").value;
	var pr3 = document.getElementById("percent3").value;
	
	var co4 = document.getElementById("course4").value;
	var su4 = document.getElementById("schoolUniversity4").value;
	var py4 = document.getElementById("passingYear4").value;
	var pr4 = document.getElementById("percent4").value;
	
}

function isExperienceDetailsFilled(){
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
        	
        	var em1Name = document.getElementById("employerName1").value; 
        	var em1Desg = document.getElementById("designation1").value; 
        	var em1DurFrom = document.getElementById("durationFrom1").value; 
        	var em1DurTill = document.getElementById("durationTill1").value; 
        	var em1Industry = document.getElementById("industry1").value; 
        	var em1totExp = document.getElementById("totalExperience1").value; 
        	var em1CtcFixed = document.getElementById("ctcFixed1").value; 
        	var em1CtcVar = document.getElementById("ctcVariable1").value;
        	var em1FirRefName1 = document.getElementById("refName101").value;
        	var em1FirRefCont1 = document.getElementById("refContact101").value;
        	var em1FirRefName2 = document.getElementById("refName102").value;
        	var em1FirRefCont2 = document.getElementById("refContact102").value;
        	
        	var em2Name = document.getElementById("employerName1").value; 
        	var em2Desg = document.getElementById("designation1").value; 
        	var em2DurFrom = document.getElementById("durationFrom1").value; 
        	var em2DurTill = document.getElementById("durationTill1").value; 
        	var em2Industry = document.getElementById("industry1").value; 
        	var em2totExp = document.getElementById("totalExperience1").value; 
        	var em2CtcFixed = document.getElementById("ctcFixed1").value; 
        	var em2CtcVar = document.getElementById("ctcVariable1").value;
        	var em2FirRefName1 = document.getElementById("refName101").value;
        	var em2FirRefCont1 = document.getElementById("refContact101").value;
        	var em2FirRefName2 = document.getElementById("refName102").value;
        	var em2FirRefCont2 = document.getElementById("refContact102").value;
        	
        	var preTotExp = document.getElementById("preTotExp").value;
        	var grandTotWorkExp = document.getElementById("grandTotWorkExp").value;
        	
        	
	}else{
        	document.getElementById("subDivforExperienced").style.display="none";
	}
}


function addRec(){
	var form = document.getElementById("emp-form");
	document.body.appendChild(form);
	form.method = "post";
	form.action="/personnel_on_boarding/EmployeeController?action=add";
	
	form.submit();
}


