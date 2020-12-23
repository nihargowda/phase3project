<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<h2>   
<h3><center>Admin Page</center></h3>


<h4>Purchase Report</h4>
<form action= "/SportyPhase3/Filter" method="post">
<% 

Class.forName("com.mysql.jdbc.Driver");

Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String qry1="select DISTINCT category from purchases";
Statement state=con1.createStatement();
ResultSet rs1= state.executeQuery(qry1);
%>
CATEGORY: <select name="category">
<option>----</option>
<% while(rs1.next()){
	
	%>
<option> <%=rs1.getString("category") %></option>
<%} %>

</select>

<input type="submit" value="Filter ">
</form>

<form action= "/SportyPhase3/Filter2" method="post">
<% 

Class.forName("com.mysql.jdbc.Driver");

Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String qry2="select DISTINCT date_added from purchases";
Statement state1=con2.createStatement();
ResultSet rs2= state1.executeQuery(qry2);
%>
DATE_ADDED: <select name="date">
<option>----</option>
<% while(rs2.next()){
	
	%>
<option> <%=rs2.getString("date_added") %></option>
<%} %>

</select>

<input type="submit" value="Filter ">

</form>




<table border=1 cellspacing=2 cellpadding=4>
 	<tr>
 		<td><b>purchaseId</b></td>
 		<td><b>UserName</b></td>
 		<td><b>UserEmail</b></td>
 		<td><b>ProductId</b></td> 
 		<td><b>PurchaseDate</b></td> 
 			<td><b>Category</b></td>
 		<td><b> <b></b></b></td>
 	</tr>



<tr>
<% 
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String qry="select * from purchases";
Statement s= con.createStatement();
ResultSet rs= s.executeQuery(qry);
%><tr>
<%while(rs.next()){ %> 
  <td><%    out.print(rs.getString(1)); %> </td>
 <td><% 	out.print(rs.getString(2));%> </td>

  <td><% 	out.print(rs.getString(3));%> </td>
 <td><% 	out.print(rs.getString(4));%> </td>
  <td><% 	out.print(rs.getString(5));%> </td>
    <td><% 	out.print(rs.getString(6));%> </td>
 <td>

	
	

	</td>
	
	</tr>
	<% }
}
catch(Exception e){}
%>

</table>

</h2>
<br></br><a href="/SportyPhase3/adminsuccess.jsp">Admin Page</a>

</body>
</html>

