<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.qn.model.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

ArrayList<Car>cardetails=(ArrayList<Car>)session.getAttribute("scardetails");
for(Car x:cardetails){
	out.println(x);

}

%></body>
</html>