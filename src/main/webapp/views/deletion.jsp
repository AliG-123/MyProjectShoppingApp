<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	
		<div class="card text-center">
  <div style="font-size:25px"class="card-header">
    <ul class="nav nav-pills card-header-pills">
    <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/shop">Buy Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/accountbalance">View account balance</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/changedetails"> Change account details</a>
      </li>
      <li class="nav-item">
		<a class="nav-link active" href="deleteaccountpage">Delete Account</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/logout">Log out</a>
      </li>
    </ul>
  </div>
  <div style="font-size:25px" align = "right">
  <a style = "color: blue">Logged in User: </a>
  <a style = "color: red">${user.username}</a>
  </div>

<h1 align = "center">Account Deletion Page</h1><br><br>

<h3 align = "center"; style = "color: Blue">Please confirm your password to delete account</h3>

	<form align = "center" action="deleteaccount" method="post">
		<div align= "center" style="margin-left: 500px; margin-right: 500px" class="form-group">
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control"
					placeholder="Password" name="password">
			</div>
		</div>
		
		<button type="submit" class="btn btn-primary">Confirm</button><br><br>
	</form>
	<h3 align = "center" style = "color: Green" >${AccountDeleted}</h3>
	<h3 align = "center" style = "color: Red" >${IncorrectPassword}</h3>
	<h4 align = "center" ><a href="/welcome"><< Back to home page</a></h4>
</div>
</body>
</html>