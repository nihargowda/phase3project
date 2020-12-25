<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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

<h3><center>Admin Page</center></h3>

<h4>Manage Products</h4>
<form action="/SportyPhase3/Category" method="post">
Filter By Category :<select name= "category">
<option>---------</option>
<option>formal</option>
<option>casual</option>
<option>sport</option>
</select>
<input type="submit" value="Filter ">

</form>
<br></br><a href="/SportyPhase3/adminsuccess.jsp">Admin Page</a>


<table border=1 cellspacing=2 cellpadding=4>
 	<tr>
 		<td><b>ProductId</b></td>
 		<td><b>ProductName</b></td>
 		<td><b>Price</b></td>
 		<td><b>Category</b></td> 
 		</tr><% 
 



try{
Class.forName("com.mysql.jdbc.Driver");

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String qry="select * from eproduct";
Statement s= con.createStatement();
ResultSet rs= s.executeQuery(qry);
%><tr>
<%while(rs.next()){ %> 
  <td><%    out.print(rs.getString(1)); %> </td>
 <td><% 	out.print(rs.getString(2));%> </td>
 <td><% 	out.print(rs.getString(3));%> </td>
 
 <td><% 	out.print(rs.getString(5));%> </td>
 
	
	
	<br>
	</td>
	
	</tr>
	<% }
}
catch(Exception e)
{}
%>

</table>

</h2>

</body>
</html>