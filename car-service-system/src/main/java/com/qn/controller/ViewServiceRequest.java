package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;
public class ViewServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String carregnumber=request.getParameter("carregnumber");
		
		Car c=new Car();
		c.setUsername(username);
		c.setCarregnumber(carregnumber);
	String status=c.viewService();
	HttpSession session=request.getSession();
	session.setAttribute("sstatus", status);
	if(status==null) {
		response.sendRedirect("/car-service-system/viewservicefailure.jsp");
	}
	else {
		response.sendRedirect("/car-service-system/viewservicesuccess.jsp");	
	}
			}

}
