package com.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.Dbconnection;

import com.connection.*;

public class UserDaoLayer {
	
	String name;
	String storename;
	String storecountry;
	String storecity;
	String storearea;
	String email;
	String username;
	String userpassword;
	String empid;
	
	public UserDaoLayer(UserRegisterBean user) {
		super();
		//this.user = user1;
		name=user.getName();
		storename=user.getUserstorename();
		 storecountry=user.getUsercountry();	
		 storecity=user.getUsercity();
		 storearea=user.getUserarea();
		 email=user.getUseremail();
		 username=user.getUserloginid();
		 userpassword=user.getUserloginpassword();
		 empid=user.getEmployeeid();
	}
	
	
	public boolean isRegister() {
		boolean register=false;
	Connection conn=null;
	PreparedStatement prepstmt=null;
     
     try {
	 conn=Dbconnection.getConnection();
	 
	    String query="INSERT INTO Metro_shop(id,name,store,country,user_name,password,mail_id,city,area) values(?,?,?,?,?,?,?,?,?)";
	    prepstmt= conn.prepareStatement(query);
	    
	      prepstmt.setString(1,empid);
	      prepstmt.setString(2,name);
	      prepstmt.setString(3,storename);
	      prepstmt.setString(4,storecountry);
	      prepstmt.setString(5,username);
	      prepstmt.setString(6,userpassword);
	      prepstmt.setString(7,email);
	      prepstmt.setString(8,storecity);
	      prepstmt.setString(9,storearea);
	      
	      prepstmt.executeUpdate();
	       return register=true;
    }catch(Exception e){
		  System.out.println("connection fail :" +e);
	  }
		
			finally {
				if (prepstmt != null) {
					try {
						prepstmt.close();
					} catch (Exception e) {
						System.out.println("connection fail:" + e);
					}

				}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("connection fail:" + e);
				}

			}
		} 
	 return register;
	}

}
