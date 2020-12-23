package com.phase3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member")
public class MemberFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MemberFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String empty="";
		PrintWriter out= response.getWriter();
		out.print("	<h3><center>Search Results</center></h3>");
		out.print("<br></br><a href='/SportyPhase3/adminsuccess.jsp'>Admin Page</a>");
		out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminmembers.jsp'>User Lists</a><br></br>");
		
	if(name.equals(empty)) {	
		out.print("<br>"+"No User Found"+"<br>");}
	else {
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
			
			String Query="select * from users where fname like '%"+name+"%' or lname like'%"+name+"%'";
			Statement state= con.createStatement();
			ResultSet rs=state.executeQuery(Query);
			
		while(rs.next()) {
			
		out.print("UserID :"+rs.getString(1)+"<br>");
		out.print("UserName :"+rs.getString(2)+" "+rs.getString(3)+"<br>");
		out.print("Address:"+rs.getString(4)+"<br>");
		out.print("Email:"+rs.getString(6)+"<br>");
		out.print("Registered Date :"+rs.getString(5)+"<br>");
		out.print("_________________________________________"+"<br><br>");
		
			}}
		
		
catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();}}
			
			

		out.print("<br></br><a href='/SportyPhase3/adminsuccess.jsp'>Admin Page</a>");
		out.print("<br></br><a href='/SportyPhase3/adminmembers.jsp'>User Lists</a>");
		
	}
}
