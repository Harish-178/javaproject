package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
private String username;
private String password;
private Connection con;
public Admin(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public Admin() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [username=" + username + ", password=" + password + "]";
}

{
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system","root","harii@17");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public int AdminLogin() {
	try {
	 String s="select* from admin where username=?";
	 PreparedStatement pstmt=con.prepareStatement(s);
	 pstmt.setString(1, username);
	 ResultSet res=pstmt.executeQuery();
	 if(res.next()) {
		 if(password.equals(res.getString(2))) {
			 return 1;
		 }
		 else {
			 return 0;
		 }
	 }
	 else return -1;
		
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
	return 0;
	
}




}
