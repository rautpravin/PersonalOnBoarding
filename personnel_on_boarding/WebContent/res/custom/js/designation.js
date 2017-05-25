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
	loadAllDesignations();
}

function loadAllDesignations(){
	getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				document.getElementById("table-space-designation").innerHTML = "<h3 style='text-align: center;'>No Record(s) available!</h3>";
			}else{
				fillTableIndustry(data);
			}
		}else{
			document.getElementById("table-space-designation").innerHTML = "<h3 style='width:100px;'>loading <marquee>.....</marquee></h3>";
		}
	}
	xmlHttpRequest.open("get", "/personnel_on_boarding/designation.do?action=getall", true);
	xmlHttpRequest.send();
}

function fillTableIndustry(data){
	var jsonData = JSON.parse(data);
	var table = "<table class='table table-striped table-hover' id='table-designation'>";
	var thead = "<thead>";
	thead += "<tr>";
	thead += "<th>Desg Id</th>";
	thead += "<th>Designation Name</th>";
	thead += "<th>Update</th>";
	thead += "<th>Delete</th>";
	thead += "</tr>";
	thead += "</thead>";
	
	
	var tbody = "<tbody>";
	for(i=0;i<jsonData.length;i++){
		tbody += "<tr>";
		tbody += "<td>"+jsonData[i].designationId+"</td>";
		tbody += "<td>"+jsonData[i].designationName+"</td>";
		tbody += "<td><button id='"+jsonData[i].designationId+"' onclick='getRecToUpdate(this)' class='btn btn-warning' style='padding: 3px;'>Update</button></td>";
		tbody += "<td><button id='"+jsonData[i].designationId+"' onclick='del(this)' class='btn btn-danger' style='padding: 3px;'>Delete</button></td>";
		tbody += "</tr>";
		
	}
	tbody += "</tbody>";
	table+=thead;
	table+=tbody;
	table+="</table>";
	document.getElementById("table-space-designation").innerHTML = table;

}



function save(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
			
			if(data==="Error"){
				alert("unable to save state record!");
			}else{
				loadAllDesignations();
			}
		}else{
			//progress bar
		}
		closeForm();
	}
	if(isValidData()){
		var designationName = document.getElementById("designation-name").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/designation.do?action=add&designation-name="+designationName, true);
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
					document.getElementById("designation-name").value = recToUpdate.designationName;
					showForm("update");
				}else{
					
				}
			}
		}
	}
	
	xmlHttpRequest.open("get", "/personnel_on_boarding/designation.do?action=getbyid&designation-id="+btn.id, true);
	xmlHttpRequest.send();
	
}

function update(){
	getAjaxRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var data = xmlHttpRequest.responseText;
		
			if(data==="Error"){
				alert(data +" : unable to update record!");
			}else{
				loadAllDesignations();
			}
			
			closeForm();
		}
	}
	
	if(isValidData()){
		var designationId = recToUpdate.designationId;
		var designationName = document.getElementById("designation-name").value;
		xmlHttpRequest.open("get", "/personnel_on_boarding/designation.do?action=update&designation-id="+designationId+"&designation-name="+designationName, true);
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
				loadAllDesignations();
			}
		}
		xmlHttpRequest.open("get", "/personnel_on_boarding/designation.do?action=delete&designation-id="+btn.id, true);
		xmlHttpRequest.send();
	}
}

//modal-state-form
function showForm(str){
	$('#modaldesignationform').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	
	$(document).ready(function(){
		$("#modaldesignationform").modal('show');
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
		$("#modaldesignationform").modal('hide');
	});

	document.getElementById("form-designation").reset();
}



function isValidData(){
	var flag = true;
	var f = document.getElementById("form-designation");
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