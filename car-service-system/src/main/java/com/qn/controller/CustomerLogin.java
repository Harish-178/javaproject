package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Customer;

public class CustomerLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username	=request.getParameter("username");
	String password=request.getParameter("password");
	
 Customer c=new Customer();
c.setUsername(username);
c.setPassword(password);
int status=c.CustomerLogin();
if(status==1) {
	String name=c.getName();
	HttpSession session=request.getSession();
	session.setAttribute("sname",name );
	session.setAttribute("susername",username );
	response.sendRedirect("/car-service-system/customerloginsuccess.jsp");
}
else if (status==-1) {
	response.sendRedirect("/car-service-system/invalidcustomerusername.jsp");
	
}
else {
	response.sendRedirect("/car-service-system/invalidcustomerpassword.jsp");

}
		
		
	}
}
