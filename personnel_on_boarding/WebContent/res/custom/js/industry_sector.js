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
	loadAllIndustrySectors();
}


function loadAllIndustrySectors(){
	getAjaxRequest();
	xmlHttpRequest.open("get","/personnel_on_boarding/industry_sector.do?action=getall", true);
	xmlHttpRequest.send();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				document.getElementById("table-space-industry-sector").innerHTML = "<h3 style='text-align: center;'>No Record(s) available!</h3>";
			}else{
				fillTableState(data);
			}
		}else{
			document.getElementById("table-space-industry-sector").innerHTML = "Loading<marquee>....</marquee>";
		}
	}
}


function fillTableState(data){
	var jsonData = JSON.parse(data);
	var table = "<table class='table table-striped table-hover' id='table-industry-sector'>";
	var thead = "<thead>";
	thead += "<tr>";
	thead += "<th>Sector Id</th>";
	thead += "<th>Sector Name</th>";
	thead += "<th>Industry Name</th>";
	thead += "<th>Update</th>";
	thead += "<th>Delete</th>";
	thead += "</tr>";
	thead += "</thead>";
	
	
	var tbody = "<tbody>";
	for(i=0;i<jsonData.length;i++){
		tbody += "<tr>";
		tbody += "<td>"+jsonData[i].sectorId+"</td>";
		tbody += "<td>"+jsonData[i].sectorName+"</td>";
		tbody += "<td>"+jsonData[i].industryName+"</td>";
		tbody += "<td><button id='"+jsonData[i].sectorId+"' onclick='getRecToUpdate(this)' class='btn btn-warning' style='padding: 3px;'>Update</button></td>";
		tbody += "<td><button id='"+jsonData[i].sectorId+"' onclick='del(this)' class='btn btn-danger' style='padding: 3px;'>Delete</button></td>";
		tbody += "</tr>";
		
	}
	tbody += "</tbody>";
	table+=thead;
	table+=tbody;
	table+="</table>";
	document.getElementById("table-space-industry-sector").innerHTML = table;

}


function loadIndustries(){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var selIndustries = document.getElementById("industries");
		selIndustries.options.length = 0;
		
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				alert("no industries found!");
			}else{
				var jsonData = JSON.parse(data);
				var empty = document.createElement("option");
				empty.value = "";
				empty.text = "";
				selIndustries.appendChild(empty);
				for(i=0;i<jsonData.length;i++){
					var option = document.createElement("option");
					option.value = jsonData[i].industryId;
					option.text  = jsonData[i].industryName;
					selIndustries.appendChild(option);
				}
			}
		}
	}
	
	xmlHttpRequest.open("get","/personnel_on_boarding/industry.do?action=getall", true);
	xmlHttpRequest.send();
}


function save(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				alert("unable to save industry sector record!");
			}else{
				loadAllIndustrySectors();
			}
		}else{
			//progress bar
		}
		closeForm();
	}
	if(isValidData()){
		var industrySectorName = document.getElementById("industry-sector-name").value;
		var industryId = document.getElementById("industries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/industry_sector.do?action=add&industry-sector-name="+industrySectorName+"&industry-id="+industryId, true);
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
					document.getElementById("industry-sector-name").value = recToUpdate.sectorName;
					//var sel = document.getElementById("industries");
					document.getElementById("default-industry-val").innerHTML = " (default value : "+recToUpdate.industryName+")";
					showForm("update");
				}else{
					
				}
			}
		}
	}
	
	xmlHttpRequest.open("get", "/personnel_on_boarding/industry_sector.do?action=getbyid&industry-sector-id="+btn.id, true);
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
				loadAllIndustrySectors();
			}
			
			closeForm();
		}
	}
	
	if(isValidData()){
		var industrySectorId = recToUpdate.sectorId;
		var industrySectorName = document.getElementById("industry-sector-name").value;
		var industryId = document.getElementById("industries").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/industry_sector.do?action=update&industry-sector-id="+industrySectorId+"&industry-sector-name="+industrySectorName+"&industry-id="+industryId, true);
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
				if(data==="Error")
					alert("Unable to delete record!");
				else
					loadAllIndustrySectors();
			}
		}
		xmlHttpRequest.open("get", "/personnel_on_boarding/industry_sector.do?action=delete&industry-sector-id="+btn.id, true);
		xmlHttpRequest.send();
	}
}

//modal-state-form
function showForm(str){
	loadIndustries();
	
	$('#modalindustrysectorform').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	
	$(document).ready(function(){
		$("#modalindustrysectorform").modal('show');
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
		$("#modalindustrysectorform").modal('hide');
	});
	document.getElementById("default-industry-val").innerHTML = "";
	document.getElementById("form-industry-sector").reset();
}



function isValidData(){
	var flag = true;
	var f = document.getElementById("form-industry-sector");
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
	
	if(!flag)
		alert("all * fields are manditory!");
		
	return flag;
}