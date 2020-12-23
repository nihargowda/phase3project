<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="/SportyPhase3/AdminLogin" method="post">
 <table border=1 cellspacing=5 cellpadding=5>
 	<tr>
 		<td width=25%>Admin id*</td>
 		<td><input name="admin_id" maxlength=20></td>
 	</tr>
 	<tr>
 		<td width=25%>Admin Password*</td>
 		<td><input name="password" maxlength=10 type="password"></td>
 	</tr>
 	<tr>
 		<td colspan=2>
 			<button>Login</button>
 		</td>
 	</tr>
 </table>
</form>
<jsp:include page="/adminfooter.jsp"></jsp:include>
</body>
</html>