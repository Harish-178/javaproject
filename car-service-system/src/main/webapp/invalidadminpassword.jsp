<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>invalid admin password</h1>
<form action="/car-service-system/AdminLogin">
<h1>Login into your account -admin</h1>
  <table>
    <tr>
      <td>User Name</td>
      <td><input type="text" name="username" required></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="password" required></td>
    </tr>
    <tr>
      <td><input type="submit" value="Login" id="login"></td>
    </tr>
  </table>
</form>

</body>
</html>