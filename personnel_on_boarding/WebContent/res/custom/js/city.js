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

window.onload = function(){
	loadAllCities();
}

function loadAllCities(){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				document.getElementById("table-space-city").innerHTML = "<h3 style='text-align: center;'>No Record(s) available!</h3>";
			}else{
				fillTableCity(data);
			}
		}else{
			document.getElementById("table-space-city").innerHTML = "<h3 style='width:100px;'>loading <marquee>.....</marquee></h3>";
		}
	}
	xmlHttpRequest.open("get", "/personnel_on_boarding/city.do?action=getall", true);
	xmlHttpRequest.send();
}

function fillTableCity(data){
	var jsonData = JSON.parse(data);
	var table = "<table class='table table-striped table-hover' id='table-city'>";
	var thead = "<thead>";
	thead += "<tr>";
	thead += "<th>City Id</th>";
	thead += "<th>City Name</th>";
	thead += "<th>State Name</th>";
	thead += "<th>Country Name</th>";
	thead += "<th>Update</th>";
	thead += "<th>Delete</th>";
	thead += "</tr>";
	thead += "</thead>";
	
	
	var tbody = "<tbody>";
	for(i=0;i<jsonData.length;i++){
		tbody += "<tr>";
		tbody += "<td>"+jsonData[i].cityId+"</td>";
		tbody += "<td>"+jsonData[i].cityName+"</td>";
		tbody += "<td>"+jsonData[i].stateName+"</td>";
		tbody += "<td>"+jsonData[i].countryName+"</td>";
		tbody += "<td><button id='"+jsonData[i].cityId+"' onclick='getRecToUpdate(this)' class='btn btn-warning' style='padding: 3px;'>Update</button></td>";
		tbody += "<td><button id='"+jsonData[i].cityId+"' onclick='del(this)' class='btn btn-danger' style='padding: 3px;'>Delete</button></td>";
		tbody += "</tr>";
		
	}
	tbody += "</tbody>";
	table+=thead;
	table+=tbody;
	table+="</table>";
	document.getElementById("table-space-city").innerHTML = table;

}


function loadCountries(){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selCountries = document.getElementById("countries");
		selCountries.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				alert("no country(s) found!");
			}else{
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
			}
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/country.do?action=getall", true);
	xmlHttpRequest.send();
}


function loadStatesByCountry(country){
	getAjaxRequest();
	xmlHttpRequest.open("get","/personnel_on_boarding/state.do?action=getbycountry&country-id="+country.value, true);
	xmlHttpRequest.send();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				alert("no state(s) found!");
			}else{
				var selStates = document.getElementById("states");
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

function save(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				alert("unable to save state record!");
			}else{
				loadAllCities();
			}
		}else{
			//progress bar
		}
		closeForm();
	}
	if(isValidData()){
		var cityName = document.getElementById("city-name").value;
		var stateId = document.getElementById("states").value;
		var countryId = document.getElementById("countries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/city.do?action=add&city-name="+cityName+"&country-id="+countryId+"&state-id="+stateId, true);
		xmlHttpRequest.send();
	}
}




var recToUpdate = "";

function getRecToUpdate(btn){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;

			if(data==="Error"){
				alert(data +" :no record found with this id! "+btn.id);
			}else{
				recToUpdate = JSON.parse(data);
				if(recToUpdate!=""){
					document.getElementById("city-name").value = recToUpdate.cityName;
					var sel = document.getElementById("countries");
					document.getElementById("default-country-val").innerHTML = " (default value : "+recToUpdate.countryName+")";
					document.getElementById("default-state-val").innerHTML = " (default value : "+recToUpdate.stateName+")";
					
					showForm("update");
				}else{
					
				}
			}
		}
	}
	
	xmlHttpRequest.open("get", "/personnel_on_boarding/city.do?action=getbyid&city-id="+btn.id, true);
	xmlHttpRequest.send();
	
}

function update(btn){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
		
			if(data==="Error"){
				alert(data +" : unable to update record!");
			}else{
				loadAllCities();
			}
			
			closeForm();
		}
	}
	
	if(isValidData()){
		var cityId = recToUpdate.cityId;
		var cityName = document.getElementById("city-name").value;
		var stateId = document.getElementById("states").value;
		var countryId = document.getElementById("countries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/city.do?action=update&city-id="+cityId+"&city-name="+cityName+"&state-id="+stateId+"&country-id="+countryId, true);
		xmlHttpRequest.send();
	}
}



function del(btn){
	
	var flag = confirm("are you sure to delete this record?");
	if(flag){
		getAjaxRequest();
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				var data = xmlHttpRequest.responseText;
				loadAllCities();
			}
		}
		xmlHttpRequest.open("get", "/personnel_on_boarding/city.do?action=delete&city-id="+btn.id, true);
		xmlHttpRequest.send();
	}
}

//modal-state-form
function showForm(str){
	loadCountries();
	$(document).ready(function(){
		$("#modalcityform").modal('show');
	});
	
	if(str==="update"){
		document.getElementById("btnSave").style.display = "none";
		document.getElementById("btnUpdate").style.display = "block";
	}
	else if(str=="save"){
		//clearFormFields();
		document.getElementById("btnSave").style.display = "block";
		document.getElementById("btnUpdate").style.display = "none";
	}
	else {
		alert("check showForm(str)....!!!");
	}
}

function closeForm(){
	$('#modalcityform').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	
	$(document).ready(function(){
		$("#modalcityform").modal('hide');
	});
	document.getElementById("default-country-val").innerHTML = "";
	document.getElementById("default-state-val").innerHTML = "";
	document.getElementById("form-city").reset();
}



function isValidData(){
	var flag = true;
	var f = document.getElementById("form-city");
	var n = f.elements.length;
	for(i=0;i<n;i++){
		var cls = f.elements[i].className.split(" ");
		for(j=0;j<cls.length;j++){
			if(cls[j]==="manditory"){
				if(f.elements[i].value===""){
					flag = false;
					break;
				}
			}
		}
	}
		
	if(!flag) alert("all * fields are manditory!");
	
	return flag;
}