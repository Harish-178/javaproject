package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;
public class UpdateServiceStatus extends HttpServlet {
 @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String carregnumber= request.getParameter("carregnumber");
	String servicestatus=request.getParameter("servicestatus");
	
	Car c=new Car();
	c.setCarregnumber(carregnumber);
	c.setServicestatus(servicestatus);
int rows=c.updateServiceStatus();
if(rows==0) {
	response.sendRedirect("/car-service-system/updateservicestatusfailure.jsp");
}
else {
	response.sendRedirect("/car-service-system/updateservicestatussuccess.jsp");
}

	}
}
