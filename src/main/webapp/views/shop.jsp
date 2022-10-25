<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.cohort20.to.User" %>
<%@ page import="com.cohort20.dao.UserDao" %>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
	<body>
	<div style = "font-size:40px">
	<div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills">
    <li class="nav-item">
        <a class="nav-link" href="/welcome">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="/shop">Buy Products</a>
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
  <div style = "font-size:40px"> 
<form action="buy" method="post">
<BR>
<table style="width:100%" border="2" class="table table-striped table-bordered">
<thead class="thead-dark">
   <tr style = "font-size:40px">
        <th>productID</th>
        <th>Stock Count</th>
        <th>Price</th>
        <th>Product</th>
        <th>Buy</th>
   </tr>
   <%
   try
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment2", "root", "admin123");
       PreparedStatement pstmt=conn.prepareStatement("select * from product");
       ResultSet rs=pstmt.executeQuery();
       while(rs.next())
       {
   %>
           <tr style = "font-size:40px">
           <td ><%=rs.getInt("productID")%></td>
           <td><%=rs.getInt("unitCount")%></td>
           <td>£<%=rs.getBigDecimal("price")%></td>
           <td><%=rs.getString("name")%></td>
           <!--<td><input type="checkbox" name="productID" value=<=rs.getInt("productID")%>></td>-->
           <td><button type="submit" 
           				name = "productID" value = <%=rs.getInt("productID")%> >Buy</button><BR></td></tr>
           
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
<div align = "center" >
<br>
<h2 style = "color: Green">${ItemBought}</h2>
<h2 style = "color: Red">${OutofStock}</h2>
<h1>Account balance is £ ${user.getAccountBalance()}</h1>
        <a href="/logout">Log out</a><br>
	</div>
	</div>
	 </body>
<!-- 

<div class="row card-deck">
    <div class="col-lg-4 col-md-6 mb-4" *ngFor="let order of productOrders">
        <div class="card text-center">
            <div class="card-header">
                <h4>${fname}</h4>
            </div>
            <div class="card-body">
                <a href="#"><img class="card-img-top" src={https://media.istockphoto.com/photos/tomato-picture-id174930196?s=612x612} 
                    alt=""></a>
                <h5 class="card-title">${{order.product.price}}</h5>
                <div class="row">
                    <div class="col-4 padding-0" *ngIf="!isProductSelected(order.product)">
                        <input type="number" min="0" class="form-control" 
                            [(ngModel)]=order.quantity>
                    </div>
                    <div class="col-4 padding-0" *ngIf="!isProductSelected(order.product)">
                        <button class="btn btn-primary" (click)="addToCart(order)"
                                [disabled]="order.quantity <= 0">Add To Cart
                        </button>
                    </div>
                    <div class="col-12" *ngIf="isProductSelected(order.product)">
                        <button class="btn btn-primary btn-block"
                                (click)="removeFromCart(order)">Remove From Cart
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
    <div class="card-header text-center">Shopping Cart</div>
    <div class="card-body">
        <h5 class="card-title">Total: ${{total}}</h5>
        <hr>
        <h6 class="card-title">Items bought:</h6>

        <ul>
            <li *ngFor="let order of orders.productOrders">
                {{ order.product.name }} - {{ order.quantity}} pcs.
            </li>
        </ul>

        <button class="btn btn-light btn-block" (click)="finishOrder()"
             [disabled]="orders.productOrders.length == 0">Checkout
        </button>
    </div>
</div>
