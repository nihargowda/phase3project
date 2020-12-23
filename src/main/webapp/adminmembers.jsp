<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<h2>   
<h3><center>Admin Page</center></h3>


<h4>List Of Members</h4>



<table border=1 cellspacing=2 cellpadding=4>
 	<tr>
 		<td><b>UserId</b></td>
 		<td><b>UserName</b></td>
 		<td><b>Address</b></td>
 		<td><b>DateAdded</b></td> 
 		<td><b>Email-Id</b></td>
 		<td><b> <b></b></b></td>
 	</tr>



<tr>
<% 
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
String qry="select * from users";
Statement s= con.createStatement();
ResultSet rs= s.executeQuery(qry);
%><tr>
<%while(rs.next()){ %> 
  <td><%    out.print(rs.getString(1)); %> </td>
 <td><% 	out.print(rs.getString(2)+rs.getString(3));%> </td>

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

<form action= "/SportyPhase3/Member" method="post">

Enter UserName : &nbsp <input type="text" name="name">
<input type="submit" value="SearchUser">

</form>
<br></br><a href="/SportyPhase3/adminsuccess.jsp">Admin Page</a>

</body>
</html>

