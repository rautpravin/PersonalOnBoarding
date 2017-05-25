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
	getAll();
}

function getAll(){
	
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			try{
				fillTable(xmlHttpRequest.responseText);
			}catch(e){
				document.getElementById("table-space-country").innerHTML = "<h3 style='text-align: center;'>No Record(s) available!</h3>";
			}
		}
	}
	xmlHttpRequest.open("get", "/personnel_on_boarding/country.do?action=getall", true);
	xmlHttpRequest.send();
	
}


function fillTable(data){
	var json = JSON.parse(data);
	
	var table = "<table class='table table-striped table-hover'>";
	
	var thead = "<thead>";
	thead += "<tr>";
	thead += "<th>Country Id</th>";
	thead += "<th>Country Name</th>";
	thead += "<th>Update</th>";
	thead += "<th>Delete</th>";
	thead += "</tr>";
	thead += "</thead>";

	var tbody ="<tbody>";
	for(i=0;i<json.length;i++){
		tbody+="<tr>";
		tbody+="<td>"+json[i].countryId+"</td>";
		tbody+="<td>"+json[i].countryName+"</td>";
		tbody+="<td><button id='"+json[i].countryId+"' class='btn btn-warning' style='padding: 3px;' onclick='updateForm(this)'>Update</button></td>";
		tbody+="<td><button id='"+json[i].countryId+"' class='btn btn-danger' style='padding: 3px;' onclick='del(this)'>Delete</button></td>";
		tbody+="</tr>";
	}
	tbody+="</tbody>";
	
	table+=thead;
	table+=tbody;
	
	document.getElementById("table-space-country").innerHTML = table;
	
}

var country = "";
function update(){
	var txtcn = document.getElementById("countryName");
	
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status==200){
			closeForm();
			getAll();
		}
	}
	xmlHttpRequest.open("GET", "/personnel_on_boarding/country.do?action=update&countryId="+country.countryId+"&countryName="+txtcn.value, true);
	xmlHttpRequest.send();
	
}

function updateForm(btn){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status==200){
			country = JSON.parse(xmlHttpRequest.responseText);
			document.getElementById("countryName").value = country.countryName;
		}
	}
	country = "";
	showForm("update");
	xmlHttpRequest.open("GET", "/personnel_on_boarding/country.do?action=getbyid&countryId="+btn.id, true);
	xmlHttpRequest.send();
	return country;
	
}


function del(btn){
	getAjaxRequest();

	var flag = confirm("Are you sure to delete this record ?");
	if(flag){
		xmlHttpRequest.open("GET", "/personnel_on_boarding/country.do?action=delete&countryId="+btn.id, true);
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status==200){
				alert(xmlHttpRequest.responseText);
				getAll();
			}
		}
		xmlHttpRequest.send();
	}
}


function save(){
	getAjaxRequest();
	
	var url = "/personnel_on_boarding/country.do";
	var cn = document.getElementById("countryName").value;
	var parameters = "action=add&countryName="+cn;
	xmlHttpRequest.open("POST", url, true);

	xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xmlHttpRequest.onreadystatechange = function() {
		if(xmlHttpRequest.readyState == 4) {
			var msg = xmlHttpRequest.responseText;
			closeForm();
			alert(msg);
			getAll();
		}
	}
	
	if(isValidData()){
		xmlHttpRequest.send(parameters);
	}else{
		alert("all (*) fields are manditory !");
	}
}

function showForm(str){
	$('#myModal').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	
	$(document).ready(function(){
		$("#myModal").modal('show');
	});
	
	if(str==="update"){
		document.getElementById("btnSave").style.display = "none";
		document.getElementById("btnUpdate").style.display = "block";
	}
	else if(str=="save"){
		
		document.getElementById("btnSave").style.display = "block";
		document.getElementById("btnUpdate").style.display = "none";
	}
	else {
		alert("check showForm(str)....!!!");
	}
}

function closeForm(){
	$("#myModal").modal('hide');
	
	document.getElementById("form-country").reset();
	
}


function isValidData(){
	var flag = true;
	var f = document.getElementById("form-country");
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
		
	return flag;
}