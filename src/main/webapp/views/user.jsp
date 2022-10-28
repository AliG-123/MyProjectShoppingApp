<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>user</title>
    </head>
    <body>  

	<div align = "center" >
        <h1>Username: ${user.username}</h1>
        <h1>Password: ${user.password}</h1>
        <h1>First Name ${user.firstName}</h1>
        <h1>User Email: ${user.email}</h1>
        <h1>Account Balance: ${user.accountBalance}</h1>
        <h1>Role: ${user.role}</h1>
        <div style = "fontsize:30px">
        <a href="/welcome">Home</a><br>
        <a href="/logout">Log out </a>
        </div>
	</div>
    </body>
</html>