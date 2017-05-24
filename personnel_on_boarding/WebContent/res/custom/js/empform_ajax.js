var xmlHttpRequest;

function getAjaxRequest(){
	try{	
		// other than IE
		xmlHttpRequest = new XMLHttpRequest();
	}catch(e){
		//for IE
		try{
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("your browser broke !");
				return false;
			}
		}
	}
}

function loadStates(selCountry){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange=function(){
		 if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			 var selState = document.getElementById("state");
			 selState.options.length = 0;
			 
			 var states = xmlHttpRequest.responseText.split(";");
			 for(i=0;i<states.length;i++){
				 var state = states[i].split(",");
				 var option = document.createElement("option");
				 option.value = state[0] ;
				 option.text  =  state[1];
				 selState.appendChild(option);
			 }
		 }
	 }
	xmlHttpRequest.open("get", "/personnel_on_boarding/EmployeeController?action=get-states&country="+selCountry.value, true);
	xmlHttpRequest.send();
	
}

function loadCities(selState){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange=function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var selCity = document.getElementById("city");
			selCity.options.length = 0;
			var cities = xmlHttpRequest.responseText.split(";");
			
			for(i=0;i<cities.length;i++){
				var ct = cities[i].split(",");
				var option = document.createElement("option");
				option.value = ct[0];
				option.text  = ct[1];
				selCity.appendChild(option);
			}
		}
	}
	xmlHttpRequest.open("get","/personnel_on_boarding/EmployeeController?action=get-cities&state="+selState.value, true);
	xmlHttpRequest.send();
}


function loadIndustries(){
	getAjaxRequest();
	xmlHttpRequst.onreadystatechange=function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var selIndustry1 = document.getElementById("industry1");
			var selIndustry2 = document.getElementById("industry2");
			var selAssignedIndustry = document.getElementById("assignedIndustry");
			
			selIndustry1.options.length = 0;
			selIndustry2.options.length = 0;
			selAssignedIndustry.options.length = 0;
			var industries = xmlHttpRequest.responseText.split(";");
			
			for(i=0;i<industries.length;i++){
				var industry = industries[i].split(",");
				var option = document.createElement("option");
				option.value = industry[0];
				option.text  = industry[1];
				selIndustry1.appendChild(option);
				selIndustry2.appendChild(option);
				selAssignedIndustry.appendChild(option);
			}
		}
	}
	xmlHttpRequest.open("get","/personnel_on_boarding/EmployeeController?action=get-industries", true);
	xmlHttpRequest.send();
	
}



function loadAssignedSectors(selIndustry){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var selAssignedSector = document.getElementById("assignedSector");
			selAssignedSector.options.length = 0;
			
			var sectors = xmlHttpRequest.responseText.split(";");
			for(i=0;i<sectors.length;i++){
				var sector = sectors[i].split(",");
				var option = document.createElement("option");
				option.value = sector[0];
				option.text  = sector[1];
				selAssignedSector.appendChild(option);
			}
		}
	}
	xmlHttpRequest.open("get", "&industry="+selIndustry.value, true);
	xmlHttpRequest.send();
}



function loadDesignations(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var selDesg = document.getElementById("designation");
			selDesg.options.length = 0;
			
			var designations = xmlHttpRequest.responseText.split(";");
			for(i=0;i<designations.length;i++){
				var designation = designations[i].split(",");
				var option = document.createElement("option");
				option.value = designation[0];
				option.text  = designation[1];
				selDesg.appendChild(option);
			}
		}
	}
	xmlHttpRequest.open("get", "", true);
	xmlHttpRequest.send();
}



function loadAllocationCities(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var selAllocationCity = document.getElementById("allocationCity");
			selAllocationCity.options.length = 0;
			
			var cities = xmlHttpRequest.responseText.split(";");
			for(i=0;i<cities.length;i++){
				var city = cities[i].split(",");
				var option = document.createElement("option");
				option.value = city[0];
				option.text  = city[1];
				selAllocationCity.appendChild(option);
			}
		}
	}
	xmlHttpRequest.open("get", "", true);
	xmlHttpRequest.send();
	
}