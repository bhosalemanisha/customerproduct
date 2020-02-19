package com.tdn.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
	final  String DB_URL="jdbc:mysql://localhost:3306/productdb";
	final  String DB_USER="root";
	final  String DB_PASSWORD="";
  
	public Connection getconnection()  {
		Connection con=null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			 con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println(con);
			
		} catch (ClassNotFoundException  e) {
			
			e.printStackTrace();
		}catch ( SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}






}
