package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.CustDao;
import com.nt.model.Customer;


public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();  
	     
	     String name=request.getParameter("name");  
	     String password=request.getParameter("email");  
	     String email=request.getParameter("password");  
	     String phone=request.getParameter("profile_phone");
	     String country=request.getParameter("profile_country");  
	     Customer c=new Customer();
	     c.setFname(name);
	     c.setEmail(email);
	     c.setPwd(password);
	     c.setPhno(phone);
	     c.setCountry(country);
	     
	     int status=CustDao.save(c);
	     if(status>0) {
	    	 out.print("<p>Record saved succesfully</p>");
	    	 request.getRequestDispatcher("Login.html").include(request, response); 
	     }else {
	    	 out.println("Sorry! unable to save record");  
	     }
	     out.close();
	}

}
