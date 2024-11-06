package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Car {
	private String username;
	private String carmodel;
	private String cartype;
	private String carregnumber;
	private String servicerequest;
	private String servicestatus;
	private Connection con;
	public Car(String username, String carmodel, String cartype, String carregnumber, String servicerequest,
			String servicestatus) {
		super();
		this.username = username;
		this.carmodel = carmodel;
		this.cartype = cartype;
		this.carregnumber = carregnumber;
		this.servicerequest = servicerequest;
		this.servicestatus = servicestatus;
	}
	public Car() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarregnumber() {
		return carregnumber;
	}
	public void setCarregnumber(String carregnumber) {
		this.carregnumber = carregnumber;
	}
	public String getServicerequest() {
		return servicerequest;
	}
	public void setServicerequest(String servicerequest) {
		this.servicerequest = servicerequest;
	}
	public String getServicestatus() {
		return servicestatus;
	}
	public void setServicestatus(String servicestatus) {
		this.servicestatus = servicestatus;
	}
	@Override
	public String toString() {
		return username+" "+carmodel+" "+cartype+" "+carregnumber+" "+servicerequest+" "+servicestatus;
	}

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system","root","harii@17");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int carDetails() {
		try {
			String s="insert into car values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, username);
		pstmt.setString(2, carmodel);
		pstmt.setString(3, cartype);
		pstmt.setString(4, carregnumber);
		pstmt.setString(5,"NA");
		pstmt.setString(6,"NA");
		
		int rows=pstmt.executeUpdate();
		return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int editcarDetails() {
		try {
			String s="update car set carmodel=?,cartype=? where  carregnumber=? and username=? ";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, carmodel);
			pstmt.setString(2, cartype);
			pstmt.setString(3, carregnumber);
			pstmt.setString(4, username);
			int rows=pstmt.executeUpdate();
			return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int RequestService() {
		try {
			String s="update car set servicerequest=?, servicestatus=? where username=? and carregnumber=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, servicerequest);
		pstmt.setString(2, "pending");
		pstmt.setString(3, username );
		pstmt.setString(4, carregnumber);
		int rows=pstmt.executeUpdate();
		return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public String Servicestatus() {
		try {
		String s="select * from car where   carregnumber=? and  username=?";	
	PreparedStatement pstmt=con.prepareStatement(s);
	pstmt.setString(1, carregnumber);
	pstmt.setString(2, username);
	ResultSet res=pstmt.executeQuery();
	if(res.next()) {
	servicestatus=res.getString(6);
	return servicestatus;
	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Car> viewCustomers() {
			try {
				String s="select * from car";
		PreparedStatement pstmt=	con.prepareStatement(s);
	ResultSet res=pstmt.executeQuery();
	ArrayList<Car> cardetails=new ArrayList<>();
	while(res.next()) {
		username=res.getString(1);
		carmodel=res.getString(2);
		cartype=res.getString(3);
		carregnumber=res.getString(4);
		servicerequest=res.getString(5);
		servicestatus=res.getString(6);
		
		cardetails.add(new Car(username,carmodel,cartype,carregnumber,servicerequest,servicestatus));
	}
	return cardetails;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
		
			}
	
	public String viewService() {
		try {
			String s="select * from car where username=? and carregnumber=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carregnumber);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
			servicerequest=res.getString(5);
			return servicerequest;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	public int updateServiceStatus() {
		try {
			String s="update car set servicestatus=? where carregnumber=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, servicestatus);
		pstmt.setString(2, carregnumber);
	int rows=pstmt.executeUpdate();
	return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
}
