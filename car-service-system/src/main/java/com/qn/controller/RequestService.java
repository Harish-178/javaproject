package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;

public class RequestService extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String servicerequest=	request.getParameter("servicerequest");
	String carregnumber= request.getParameter("carregnumber");
 Car c=new Car();
 HttpSession session=request.getSession();
 String username= (String)session.getAttribute("susername");
 
 c.setServicerequest(servicerequest);
 c.setCarregnumber(carregnumber);
 c.setUsername(username);
 int status=c.RequestService();
 if(status==0) {
	 response.sendRedirect("/car-service-system/servicerequestfailure.jsp");
 }
 else {
	 response.sendRedirect("/car-service-system/servicerequestsuccess.jsp");
 }
 
	}
	}
