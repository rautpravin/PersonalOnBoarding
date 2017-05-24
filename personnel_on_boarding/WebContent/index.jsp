<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Welcome | PersonalOnBoarding</title>

    <!-- Bootstrap -->
    <link href="/personnel_on_boarding/res/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<div class="container">
	<div class="row">
	<div class="col-sm-6 col-md-5 col-lg-4" style="padding: 10px; margin-top: 20px;">
	<form action="">
		<div class="form-group">
		<h3 style="text-align: center; font-weight: bold;">Personnel On Boarding</h3>
		<hr>
		</div>
		<div class="form-group">
		<label>Username</label>
		<input type="text" class="form-control" name="username" placeholder="Username"/>
		</div>
		
		<div class="form-group">
		<label>Password</label>
		<input type="password" class="form-control" name="password" placeholder="Password"/>
		</div>
		
		<div class="form-group">
		<input type="checkbox" checked="checked" />&nbsp;&nbsp;Keep me signed in!
		<button type="button" class="btn btn-primary pull-right">Login</button>
		</div>
	</form>
	</div>
	<div class="col-sm-6 col-md-7 col-lg-8">
	</div>
	</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/personnel_on_boarding/res/js/bootstrap.min.js"></script>
</body>
</html>