<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<h2>   
<h3><center>Welcome to SportyShoes Online Shopping Portal</center></h3>






<table border=1 cellspacing=2 cellpadding=4>
 	<tr>
 		<td><b>ProductId</b></td>
 		<td><b>ProductName</b></td>
 		<td><b>Price</b></td>
 		<td><b>Category</b></td> 
 		<td><b> <b></b></b></td>
 	</tr>



<tr>
<% 
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
 <td>

	
	
	<a href='/SportyPhase3/userlogin.jsp?id=<%=rs.getString(1) %>&&category=<%=rs.getString(5) %>' >Add to Cart</a><br>
	</td>
	
	</tr>
	<% }
}
catch(Exception e){}
%>

</table>

</h2>

</body>
</html>

