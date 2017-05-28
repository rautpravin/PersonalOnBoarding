
function getAjaxRequest(){

	try{	
		// other than IE
		return new XMLHttpRequest();
	}catch(e){
		//for IE
		try{
			return ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				return ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("your browser broke !");
				return false;
			}
		}
	}

}



window.onload = function(){
	hideAll();
	document.getElementById("div-personal-details").style.display = "block";
	
	loadCountries();
	loadIndustries();
	loadAllocationCities();
	loadDesignations();
}



function loadCountries(){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selCountries = document.getElementById("countries");
		selCountries.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;

			try{
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selCountries.appendChild(empty);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].countryId;
					option.text  = jsonData[i].countryName;
					selCountries.appendChild(option);
				}
			}catch(e){
				document.write("please refresh page !");
			}	
		}else{
			
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/country.do?action=getall", true);
	xmlHttpRequest.send();

}

function loadStates(country){
	var xmlHttpRequest = getAjaxRequest();
	xmlHttpRequest.open("get","/personnel_on_boarding/state.do?action=getbycountry&country-id="+country.value, true);
	xmlHttpRequest.send();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				//alert("no state(s) found!");
			}else{
				var selStates = document.getElementById("states");
				selStates.options.length = 0;
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selStates.appendChild(empty);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].stateId;
					option.text  = jsonData[i].stateName;
					selStates.appendChild(option);
				}
			}
		}
	}
}


function loadCities(state){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			try{
				var selCities = document.getElementById("cities");
				selCities.options.length = 0;
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selCities.appendChild(empty);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].cityId;
					option.text  = jsonData[i].cityName;
					selCities.appendChild(option);
				}
			}catch(e){
				document.write("please refresh page !");
			}
		
		}else{
		
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/city.do?action=getbystate&state-id="+state.value, true);
	xmlHttpRequest.send();
}


function loadAllocationCities(){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			try{
				var selAllocationCities = document.getElementById("allocation-city");
				selAllocationCities.options.length = 0;
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selAllocationCities.appendChild(empty);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].cityId;
					option.text  = jsonData[i].cityName;
					selAllocationCities.appendChild(option);
				}
			}catch(e){
				document.write("please refresh page !");
			}
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/city.do?action=getall", true);
	xmlHttpRequest.send();
}


function loadDesignations(){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			var selDesg = document.getElementById("designations");
			selDesg.options.length = 0;
			var empty = document.createElement("option");
			empty.text = "";
			empty.value = "";
			selDesg.appendChild(empty);
			try{
				var jsonData = JSON.parse(data);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].designationId;
					option.text = jsonData[i].designationName;
					selDesg.appendChild(option);
					
				}
			}catch(e){
				document.write("please refresh page !");
			}
		}
	} 
	xmlHttpRequest.open("get","/personnel_on_boarding/designation.do?action=getall", true);
	xmlHttpRequest.send();
}


function loadIndustries(){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selIndustries = document.getElementById("industries");
		var selAssIndustries = document.getElementById("assigned-industry");
		selIndustries.options.length = 0;
		selAssIndustries.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			try{
				var jsonData = JSON.parse(data);
				var empty1 = document.createElement("option");
				var empty2 = document.createElement("option");
				empty1.value = "";
				empty1.text = "";
				selIndustries.appendChild(empty1);
				
				empty2.value = "";
				empty2.text = "";
				selAssIndustries.appendChild(empty2);
				for(i=0;i<jsonData.length;i++){
					var option1 = document.createElement("option");
					option1.value = jsonData[i].industryId;
					option1.text  = jsonData[i].industryName;
					selIndustries.appendChild(option1);
					
					var option2 = document.createElement("option");
					option2.value = jsonData[i].industryId;
					option2.text  = jsonData[i].industryName;
					selAssIndustries.appendChild(option2);
				}
			}catch(e){
				document.write("please refresh page !");
			}
			
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/industry.do?action=getall", true);
	xmlHttpRequest.send();
}


function loadIndustrySectors(industry){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selSector = document.getElementById("assigned-sector");
		var selSec = document.getElementById("sectors");
		selSector.options.length = 0;
		selSec.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			try{
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selSector.appendChild(empty);
				
				var empty1 = document.createElement("option");
				empty1.value = "";
				empty1.text = "";
				selSec.appendChild(empty1);
				
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].sectorId;
					option.text  = jsonData[i].sectorName;
					selSector.appendChild(option);
					
					var opt = document.createElement("option");
					opt.value = jsonData[i].sectorId;
					opt.text  = jsonData[i].sectorName;
					selSec.appendChild(opt);
				}
			}catch(e){
				document.write("please refresh page !");
			}
			
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/industry_sector.do?action=getbyindustry&industry-id="+industry.value, true);
	xmlHttpRequest.send();
}


function save(){
	var xmlHttpRequest = getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var t = xmlHttpRequest.responseText;
			if(t==="Success")
				alert("employee added successfully!");
			else
				alert("Error : unable to add employee!");
			location.href = "/personnel_on_boarding/view/admin/employee_master.jsp";
		}
	}
	xmlHttpRequest.open("POST", "/personnel_on_boarding/employee.do?action=add", true);
	xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttpRequest.send(getParams());
}



function previous(curr, pre){
	try{
		document.getElementById(curr).style.display = "none";
		document.getElementById(pre).style.display = "block";
	}catch(e){
		alert("Exception in previous() : "+e);
	}
}

function next(curr,next){
	try{
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
	}catch(e){
		alert("exception in next()  : "+e);
	}
}


function getParams(){
	var allparams = "";
	var forms = document.getElementById("forms-container").getElementsByTagName('form');
	for(i=0;i<forms.length;i++){
		if(forms[i].id!=="div-experience-details" || forms[i].id!=="div-for-experienced" || forms[i].id!=="div-edu-qual-details"){
			var elements = forms[i].elements;
			for(j=0; j<elements.length; j++){
				if(elements[j].tagName==="SELECT" || elements[j].tagName==="INPUT"){
					allparams += elements[j].id+"="+elements[j].value+"&";		
				}
			}
		}
		if(forms[i].id==="div-experience-details"){
			var expform = document.getElementById("div-experience-details");
			allparams += "&experience-type="+expform.experiencetype.value+"&";
		}
	}
	var edu = eduQual();
	if(edu!=="")
		allparams+=edu;
	if(allExp!=="")
		allparams+="&"+allExp+"&all-exp-no="+allExpNo;
	
	return allparams;
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

function hideAll(){
	document.getElementById("div-personal-details").style.display = "none";
	document.getElementById("div-contact-details").style.display = "none";
	document.getElementById("div-address-details").style.display = "none";
	document.getElementById("div-bank-details").style.display = "none";
	document.getElementById("div-edu-qual-details").style.display = "none";
	document.getElementById("div-employment-details").style.display = "none";
	document.getElementById("div-experience-details").style.display = "none";
	document.getElementById("div-for-experienced").style.display = "none";
}

