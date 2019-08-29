package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	
	public static Connection getConnection() {
Connection con = null;
		
		try {

			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			con = DriverManager.getConnection("jdbc:oracle:thin:@aws.c0cdkq7y3nan.us-east-2.rds.amazonaws.com:1521:ORCL", "aws123", "ashok2818");
			
		
		} catch (SQLException e) {
			System.out.println("connection fail:" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("connection fail:" + e);
		}
		return con;
	}
}




