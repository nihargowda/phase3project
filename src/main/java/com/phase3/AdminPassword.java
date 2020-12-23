package com.phase3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/Password")
public class AdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminPassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username= request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String empty="";
				SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(AdminEntity.class).buildSessionFactory();
				PrintWriter out= response.getWriter();
				
				Session session=factory.getCurrentSession();
				try {
					session.beginTransaction();
			
			
				@SuppressWarnings("unchecked")
				List<AdminEntity> ls=session.createQuery("from AdminEntity a where a.admin_id='admin'").getResultList();
				   
				for(AdminEntity al:ls) {
				String oldpass=	al.getAdmin_pwd();
				
				
				
				 if(newpassword.equals("empty") || newpassword.length()<5 ) {
				out.print("Minimum Length of Password is 5, Please Re-Enter <br></br>");
				
				out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminchangepassword.jsp'>update Password page</a><br></br>");
				out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminsuccess.jsp'>Admin HomePage</a><br></br>");
				}
				 else if(oldpass.equals(oldpassword) && username.equals("admin") ) {
					 session.createQuery("update AdminEntity set admin_pwd='"+newpassword+"'").executeUpdate();
						session.getTransaction().commit();
					 out.print("Password Updated Successfully"+"<br><br>");
					 out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminsuccess.jsp'>Admin HomePage</a><br></br>");
				 }
				 else  {
						out.print("Invalid  UserName or  Old Password,Please Re-enter");
						out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminchangepassword.jsp'>update Password page</a><br></br>");
						out.print("&nbsp&nbsp&nbsp&nbsp<a href='/SportyPhase3/adminsuccess.jsp'>Admin HomePage</a><br></br>");
					}
				
				}
					
		
	}
				finally {
					factory.close();
				}
	}

}
