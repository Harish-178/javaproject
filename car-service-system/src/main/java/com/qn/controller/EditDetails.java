package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Customer;
public class EditDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	
	Customer c=new Customer(name,username,password,email);
	int rows=c.editCustomerDetails();
	
	if(rows==0) {
		response.sendRedirect("/car-service-system/editcustomerdetailsfailure.jsp");
	}
	else {
		response.sendRedirect("/car-service-system/editcustomerdetailssuccess.jsp");
	}
	
	
	}
}
