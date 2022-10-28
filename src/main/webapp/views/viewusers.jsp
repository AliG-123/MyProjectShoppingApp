<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.cohort20.to.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import="com.cohort20.dao.UserDao" %>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
	<body>
 		<div class="card text-center">
  <div style="font-size:40px"class="card-header">
    <ul class="nav nav-pills card-header-pills">
    <li class="nav-item">
        <a class="nav-link" href="/welcome">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/stocks">Replenish Stock</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="/viewallusers">View Users</a>
      </li>
      <li class="nav-item">
		<a class="nav-link" href="addProduct">Add Products</a>
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
  <br>
  <div style = "font-size:25px"> 
<form action="updateUserRole" method="post">
<table style="width:100%" border="2" class="table table-striped table-bordered">
<thead class="thead-dark">
   <tr style = "font-size:40px">
        <th>Username</th>
        <th>FirstName</th>
        <th>Email</th>
        <th>Account Balance</th>
        <th>Current Role</th>
        <th>Change</th>
   </tr>
   <%
   try
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment2", "root", "admin123");
       PreparedStatement pstmt=conn.prepareStatement("select * from users");
       ResultSet rs=pstmt.executeQuery();
       while(rs.next())
       {
   %>
           <tr style = "font-size:20px">
           <td ><%=rs.getString("username")%></td>
           <td><%=rs.getString("firstName")%></td>
           <td><%=rs.getString("Email")%></td>
           <td><%=rs.getBigDecimal("accountBalance")%></td>
           <td><%=rs.getString("role")%></td>
           <td><button type="submit" name = "username" value = <%=rs.getString("username")%>>Change Role</button><BR></td></tr>
           
   <%
       }
       
   %>
   </table>
   <%
        rs.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>
<div style = "font-size:20px" align = "center" >
<br>
<h2 style = "color: Green">${roleUpdated}</h2>
        <a href="/logout">Log out</a><br>
	</div>
	</div>
	 </body>

