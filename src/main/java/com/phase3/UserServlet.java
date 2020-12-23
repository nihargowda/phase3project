package com.phase3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 PreparedStatement prep; 
  
    public UserServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		String fname= request.getParameter("fname");
		String lname= request.getParameter("lname");
		String emailid= request.getParameter("emailid");
		String address= request.getParameter("address");
		String category=(String)session.getAttribute("category");
		String id= (String) session.getAttribute("id");
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		String empty="";
		PrintWriter out= response.getWriter();

		if(fname.equals(empty)||lname.equals(empty)||emailid.equals(empty)||address.equals(empty)||date.equals(empty)) {
			response.sendRedirect("usererror.jsp");
		}
		else {
			out.print("<h3><center>Success<center></h3>"+"<br>");
			out.print("Registration Successfull"+"<br>"+"<br>");
			out.print("<a href='/SportyPhase3/payment.jsp'>Proceed To Payment Page</a>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
			
			String Query="insert into users(fname,lname,address,date_added,emailid) values (?,?,?,?,?)";
			
			 prep=con.prepareStatement(Query);
		
			
			
			prep.setString(1,fname);
			prep.setString(2,lname);
			prep.setString(3,address);
			prep.setString(4,date);
			prep.setString(5,emailid);
			
			
		prep.executeUpdate();
			}
catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			
}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
	
		String sql= "insert into purchases(username,emailid,productID,date_added,category) values (?,?,?,?,?)";
		prep=con.prepareStatement(sql);	
		String username=fname+" "+lname;
		
		
		prep.setString(1, username);
		prep.setString(2, emailid);
		prep.setString(3, id);
		
		prep.setString(4, date);
		prep.setString(5,category);
		
		prep.executeUpdate();
		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}
		
		
		}
	
}

}
