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
	loadEmployees();
}

function loadEmployees(){
	var xmlHttpRequest = getAjaxRequest();
	
	xmlHttpRequest.onreadystatechange = function(){
		var tableSpace = document.getElementById("table-space-employee");
		if(xmlHttpRequest.status==200 && xmlHttpRequest.readyState==4){
			var data = xmlHttpRequest.responseText;
			if(data==="Error"){
				tableSpace.innerHTML = "<h3>No record(s) available!</h3>";
			}else{
				var thead = "<thead></thead>";
				thead += "<tr><th>EmpId</th><th>Emp Name</th><th>Birth Date</th><th>Gender</th><th>Mobile No</th><th>Landline No</th></tr>";
				thead += "</thead>";
				var tbody = "<tbody>";
				var jsonData = JSON.parse(data);
				for(i=0;i<jsonData.length;i++){
					tbody +="<tr>";
						tbody +="<td>"+jsonData[i].employeeId+"</td>";
						tbody +="<td>"+jsonData[i].employeeName+"</td>";
						tbody +="<td>"+jsonData[i].birthDate+"</td>";
						tbody +="<td>"+jsonData[i].gender+"</td>";
						tbody +="<td>"+jsonData[i].mobileNo+"</td>";
						tbody +="<td>"+jsonData[i].landlineNo+"</td>";
					tbody +="</tr>";
				}
				tbody +="</tbody>";
				tableSpace.innerHTML = "<table class='table table-striped table-hover'>"+thead+""+tbody+"</table>";
			}
		}else{
			tableSpace.innerHTML = "<h3 style='width: 250px;'>Loading <marquee>....</marquee></h3>";
		}
	}
	
	xmlHttpRequest.open("get", "/personnel_on_boarding/employee.do?action=getall", true);
	xmlHttpRequest.send();
}