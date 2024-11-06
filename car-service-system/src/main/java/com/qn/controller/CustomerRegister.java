package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Customer;

public class CustomerRegister extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	String name=request.getParameter("name");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String confirmpassword=request.getParameter("confirmpassword");
	String email=request.getParameter("email");
	if(password.equals(confirmpassword)) {
		Customer c=new Customer(name,username,password,email);
		int rows=c.CustomerRegister();
		
		if(rows==0) {
			response.sendRedirect("/car-service-system/customerRegisterfailure.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/customerRegistersuccess.jsp");

		}
	}
	else {
		response.sendRedirect("/car-service-system/passwordMismatch.html");

	}
			
			}

	

}
