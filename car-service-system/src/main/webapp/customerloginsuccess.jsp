<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f4f4f9;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
      margin: 0;
    }

    .message {
      background-color: #28a745;
      color: white;
      padding: 15px;
      border-radius: 5px;
      margin-bottom: 20px;
      font-size: 18px;
    }

    a {
      display: block;
      margin: 10px 0;
      padding: 10px 20px;
      text-decoration: none;
      background-color: #007bff;
      color: white;
      border-radius: 5px;
      width: 200px;
      text-align: center;
      font-size: 16px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      transition: background-color 0.3s ease, transform 0.3s ease;
    }

    a:hover {
      background-color: #0056b3;
      transform: translateY(-2px);
    }
  </style>
</head>
<body>

<%
  String name = (String)session.getAttribute("sname");
  if (name != null) {
%>
  <div class="message">
    Dear <%= name %>, you have logged in successfully.
  </div>
<%
  } else {
    response.sendRedirect("login.html");
  }
%>

<a href="cardetails.html">Enter your car details</a>
<a href="editcardetails.html">Edit your car details</a>
<a href="requestservice.html">Request for service</a>
<a href="servicestatus.html">Check service status</a>

</body>
</html>
