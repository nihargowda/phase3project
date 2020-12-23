<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<h3><center>Update Admin Login Password</center></h3><br><br>
<form action="/SportyPhase3//Password" method= "post">
Enter Username : <input type= "text" name="username" placeholder="admin"><br><br>
Enter Old Password :<input type= "password" name="oldpassword"><br><br>
Enter New Password :<input type= "password" name= "newpassword"><br><br>
<input type= "submit" value="change password" >

</form>



</body>
</html>