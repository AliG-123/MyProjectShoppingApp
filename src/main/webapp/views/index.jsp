<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 align="center">Welcome to Cohart20 Ecommerce Application</h1><br><br>
		
		<h3 align="center" style = "color: Blue">Enter your credentials!!</h3>

	<form action="login" method="post">
		<div align = "center" style="margin-left: 500px; margin-right: 500px" class="form-group">
			<div>
				<label>Username</label> <input type="text"
					class="form-control"
					placeholder="Enter Username" name="username">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control"
					placeholder="Password" name="password">
			</div>
			<button type="submit" class="btn btn-primary">Login</button><br><br>
			<h3 align = "center" style = "color: Red" >${LoginErrorMessage}</h3>
			<h4><a  href="registrationPage">New User? Register Here</a></h4>
		</div>
		
	</form>
</body>
</html>