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
  <div style="font-size:40px"class="card-header">
    <ul class="nav nav-pills card-header-pills">
    <li class="nav-item">
        <a class="nav-link active" href="#">Home</a>
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
<a class="nav-link" href="deleteaccountpage">Delete Account</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/logout">Log out</a>
      </li>
    </ul>
  </div>
  <div style="color:red;font-size:40px;">  
		<h1 align="center">WELCOME ${user.username.toUpperCase()}
	</div>
	<br>
	<div align = "center" style="font-size:40px">
	<div align = "center">
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Username</th>
					<th>First Name</th>
					<th>Email</th>
					<th>Account Balance</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td >${user.getUsername()}</td>
					<td >${user.getFirstName()}</td>
					<td >${user.getEmail()}</td>
					<td >${user.getAccountBalance()}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</div>

	<!-- <h4 align="center">
		<a href="/accountbalance"> View account balance</a>
	</h4>
	<h4 align="center">
		<a href="/changedetails"> Change account details</a>
	</h4>
	<h4 align="center">
		<a href="${pageContext.request.contextPath}/deleteaccount" onclick="return confirm('Are you sure you want to delete your account?')">Delete</a>
	</h4>
	<h4 align="center">
		<a href="/shop">Buy Products</a>
	</h4>
	
	<a href="/logout">Log out</a><br> -->
	</div>
</body>
</html>

