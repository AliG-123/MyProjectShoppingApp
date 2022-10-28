<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Balance</title>
</head>
<body>
<div style = "font-size:25px">
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
        <a class="nav-link active" href="/accountbalance">View account balance</a>
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
  <div> 
  </div>
  <div style="font-size:30px" align = "right">
  <a style = "color: blue">Logged in User: </a>
  <a style = "color: red">${user.username}</a>
  </div>
<h1 align = "center" >
Your account balance is : £${user.accountBalance}
</h1>

<h4 align = "center" ><a href="/"> Return to main menu </a></h4>
</body>
</html>