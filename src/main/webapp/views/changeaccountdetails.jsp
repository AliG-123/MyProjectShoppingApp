
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Account Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<div style = "font-size:40px">
	<div class="card text-center">
	  <div class="card-header">
	    <ul class="nav nav-pills card-header-pills">
	    <li class="nav-item">
	        <a class="nav-link" href="/welcome">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/shop">Buy Products</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/accountbalance">View account balance</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" href="/changedetails"> Change account details</a>
	      </li>
	      <li class="nav-item">
	      <a class="nav-link" href="deleteaccountpage">Delete Account</a>
	      </li>
	        <li class="nav-item">
	        <a class="nav-link" href="/logout">Log out</a>
	      </li>
	    </ul >
	  </div>
  </div>
</div>

<div style = "font-size:40px">
<h1 align = "center">Update account details</h1><br><br>

<h3 align = "center" style = "color: Blue">Enter your up-to-date details</h3>

	<form align = "center" action="accountUpdated" method="post">
		<div align= "center" style="margin-left: 500px; margin-right: 500px" class="form-group">
			<div style = "font-size:40px" class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control"
					placeholder="Password" name="password">
			
				<label for="exampleInputEmail1">First Name</label> <input type="text"
					class="form-control"
					 placeholder="Enter First Name" name="firstName">
				<label for="exampleInputEmail1">Email</label> <input type="email"
					class="form-control"
					 placeholder="Enter Email Address" name="email">
			</div>
			
		</div>
		<button type="submit" class="btn btn-primary">Submit</button><br><br>
	</form>
				<h3 align = "center" style = "color: Green" >${accountUpdated}</h3>
	<h4 align = "center" ><a href="/"><< Back to Login page</a></h4>
</div>
</body>
</html>