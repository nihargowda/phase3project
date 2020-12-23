package com.phase3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Filter")
 
public class FilterCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FilterCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String category= request.getParameter("category");
		PrintWriter out= response.getWriter();
		out.print("	<h3><center>Filtered By Category</center></h3>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/sportyshoes","root","");
			
			String Query="select * from purchases where category=?";
			PreparedStatement prep=con.prepareStatement(Query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			prep.setString(1, category);
			ResultSet rs=  prep.executeQuery();
			while(rs.next()) {
				out.print("CATEGORY :&nbsp&nbsp &nbsp  "+rs.getString(6)+"<br><br>");
		out.print("PurchaseId :&nbsp&nbsp &nbsp "+rs.getString(1)+"<br>");
		out.print("UserName :&nbsp&nbsp &nbsp "+rs.getString(2)+"<br>");
		out.print("UserEmailId :&nbsp&nbsp &nbsp "+rs.getString(3)+"<br>");
		out.print("ProductId :&nbsp&nbsp &nbsp "+rs.getString(4)+"<br>");
		out.print("DateOfPurchase :&nbsp&nbsp &nbsp "+rs.getString(5)+"<br>");
		
		out.print("_______________________________________");
			}
	
		}
catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			
}
		
		out.print("<br></br><a href='/SportyPhase3/adminsuccess.jsp'>Admin Page</a>");
		out.print("<br></br><a href='/SportyPhase3/adminpurchases.jsp'>Purchase Lists</a>");
	}

}
