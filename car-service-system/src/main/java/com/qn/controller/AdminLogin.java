package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Admin;
import com.qn.model.Customer;
public class AdminLogin extends HttpServlet {
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username	=request.getParameter("username");
			String password=request.getParameter("password");
			
		 Admin a=new Admin();
		a.setUsername(username);
		a.setPassword(password);
		int status=a.AdminLogin();
		if(status==1) {
			response.sendRedirect("/car-service-system/adminloginsuccess.jsp");
		}
		else if (status==-1) {
			response.sendRedirect("/car-service-system/invalidadminusername.jsp");
			
		}
		else {
			response.sendRedirect("/car-service-system/invalidadminpassword.jsp");

		}
	}
}
