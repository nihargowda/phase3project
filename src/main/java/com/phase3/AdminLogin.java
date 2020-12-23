package com.phase3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLogin() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminid=request.getParameter("admin_id");
		String password= request.getParameter("password");
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(AdminEntity.class).buildSessionFactory();

		
	Session session=factory.getCurrentSession();
	try {
		session.beginTransaction();
		List<AdminEntity> ls=session.createQuery("from AdminEntity a where a.admin_id='admin'").getResultList();
		for(AdminEntity al:ls) {
			String pass =	al.getAdmin_pwd();
			
			
			if(adminid.equals("admin")&&password.equals(pass)) {
				
				response.sendRedirect("adminsuccess.jsp");}
				else {
					response.sendRedirect("/SportyPhase3/adminloginerror.jsp");
				}
		}}
	finally {
		factory.close();
	}
	
		
	}

}
