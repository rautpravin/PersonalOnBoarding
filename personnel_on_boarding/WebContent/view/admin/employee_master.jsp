<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Employee Master</title>

    <!-- Bootstrap -->
    <link href="/personnel_on_boarding/res/css/bootstrap.min.css" rel="stylesheet">

	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<link href="/personnel_on_boarding/res/custom/css/commons.css" rel="stylesheet">
	  
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
			<div class="col-lg-12 master-header-container">
				<label class="master-table-label">Employee Master</label>
				<button type="button" id="btnAdd" class="btn btn-primary pull-right">Add</button>
			</div>
		</div>
		
		<div class="row">
			<div class="table-responsive" id="table-space-employee">
				
			</div>
		</div>
	
				
	</div> <!-- container -->
	
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/personnel_on_boarding/res/js/bootstrap.min.js"></script>
    
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
</body>
</html>
	
		