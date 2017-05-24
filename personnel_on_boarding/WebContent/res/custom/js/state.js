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
	loadAllStates();
}


function loadAllStates(){
	getAjaxRequest();
	xmlHttpRequest.open("get","/personnel_on_boarding/state.do?action=getall", true);
	xmlHttpRequest.send();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				document.getElementById("table-space-state").innerHTML = "<h3 style='text-align: center;'>No Record(s) available!</h3>";
			}else{
				fillTableState(data);
			}
		}
	}
}


function fillTableState(data){
	var jsonData = JSON.parse(data);
	var table = "<table class='table table-striped table-hover' id='table-state'>";
	var thead = "<thead>";
	thead += "<tr>";
	thead += "<th>State Id</th>";
	thead += "<th>State Name</th>";
	thead += "<th>Country Name</th>";
	thead += "<th>Update</th>";
	thead += "<th>Delete</th>";
	thead += "</tr>";
	thead += "</thead>";
	
	
	var tbody = "<tbody>";
	for(i=0;i<jsonData.length;i++){
		tbody += "<tr>";
		tbody += "<td>"+jsonData[i].stateId+"</td>";
		tbody += "<td>"+jsonData[i].stateName+"</td>";
		tbody += "<td>"+jsonData[i].countryName+"</td>";
		tbody += "<td><button id='"+jsonData[i].stateId+"' onclick='getRecToUpdate(this)' class='btn btn-warning' style='padding: 3px;'>Update</button></td>";
		tbody += "<td><button id='"+jsonData[i].stateId+"' onclick='del(this)' class='btn btn-danger' style='padding: 3px;'>Delete</button></td>";
		tbody += "</tr>";
		
	}
	tbody += "</tbody>";
	table+=thead;
	table+=tbody;
	table+="</table>";
	document.getElementById("table-space-state").innerHTML = table;

}


function loadCountries(){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selCountries = document.getElementById("countries");
		selCountries.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				alert("no countries found!");
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


function save(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				alert("unable to save state record!");
			}else{
				loadAllStates();
			}
		}else{
			//progress bar
		}
		closeForm();
	}
	if(isValidData()){
		var stateName = document.getElementById("state-name").value;
		var countryId = document.getElementById("countries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/state.do?action=add&state-name="+stateName+"&country-id="+countryId, true);
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
				alert(data +" :no record found with this id!");
			}else{
				recToUpdate = JSON.parse(data);
				if(recToUpdate!=""){
					document.getElementById("state-name").value = recToUpdate.stateName;
					var sel = document.getElementById("countries");
					document.getElementById("default-country-val").innerHTML = " (default value : "+recToUpdate.countryName+")";
					showForm("update");
				}else{
					
				}
			}
		}
	}
	
	xmlHttpRequest.open("get", "/personnel_on_boarding/state.do?action=getbyid&state-id="+btn.id, true);
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
				loadAllStates();
			}
			
			closeForm();
		}
	}
	
	if(isValidData()){
		var sid = recToUpdate.stateId;
		var sn = document.getElementById("state-name").value;
		var cid = document.getElementById("countries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/state.do?action=update&state-id="+sid+"&state-name="+sn+"&country-id="+cid, true);
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
				loadAllStates();
			}
		}
		xmlHttpRequest.open("get", "/personnel_on_boarding/state.do?action=delete&state-id="+btn.id, true);
		xmlHttpRequest.send();
	}
}

//modal-state-form
function showForm(str){
	loadCountries();
	
	$('#modalstateform').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	
	$(document).ready(function(){
		$("#modalstateform").modal('show');
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
	$(document).ready(function(){
		$("#modalstateform").modal('hide');
	});
	document.getElementById("default-country-val").innerHTML = "";
	document.getElementById("form-state").reset();
}



function isValidData(){
	var flag = true;
	var f = document.getElementById("form-state");
	var n = f.elements.length;
	for(i=0;i<n;i++){
		var cls = f.elements[i].className.split(" ");
		for(j=0;j<cls.length;j++){
			if(cls[j]==="manditory"){
				if(f.elements[i].value===""){
					flag = false;
					alert("all * fields are manditory!");
					break;
				}
			}
		}
	}
		
	return flag;
}