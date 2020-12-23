<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>User Registration<center></h3>


<form action ="/SportyPhase3/UserServlet" method="post">

<%

String id= request.getParameter("id");
String category=request.getParameter("category");

session.setAttribute("id",id);
session.setAttribute("category",category);
%>
Enter First Name &nbsp:<input type="text" name="fname"><br><br>
Enter LastName &nbsp:<input type="text" name="lname"><br><br>
Enter E-mail &nbsp:<input type="text" name="emailid"><br><br>
Enter Password &nbsp:<input type="password" name="pwd"><br><br>
Enter Address &nbsp:<input type="text" name="address"><br><br>
Enter Age &nbsp:<input type="number" name="address"><br><br>
<input type="submit" value="CheckOut"><br>














</form>





</body>
</html>