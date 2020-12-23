<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>Payment Gateway</center></h3>
<form action="/SportyPhase3/PaymentServlet" method=post>
<% 
String id= (String) session.getAttribute("id");
Class.forName("com.mysql.jdbc.Driver");

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String sql= "select * from eproduct where productID=?";

PreparedStatement ps= con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ps.setString(1, id);
ResultSet rs= ps.executeQuery();
while(rs.next()){
	
	out.print("Product Name"+" :"+rs.getString(2)+"<br><br>");
	out.print("Product Price"+" :"+rs.getString(3)+"<br><br>");	
}
%>

<h5>ENTER CARD DETAILS </h5>			
Select type of card: <input type="radio" name="cardtype" value="credit" >credit &nbsp &nbsp

<input type="radio" name="cardtype" value="debit" >debit
            
<br><br>
Name On Card : <input type="text" name="name"><br><br>
Card Number :<input type="number" name="number"><br><br>
Cvv :<input type="password" name="cvv"><br><br>

Expiry Date <input type="date" name="date"><br><br>
<input type="submit" value="ConfirmOrder">
</form>
</body>
</html>