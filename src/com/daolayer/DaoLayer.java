package com.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.Dbconnection;



public class DaoLayer {

	public boolean   loginProcess(String user_name,String user_password) throws ClassNotFoundException, SQLException  {
		Connection conn=null;
		Statement stmt=null;
	     boolean login=false;
	try {
		 conn=Dbconnection.getConnection();
		
		 String query="SELECT user_name, password FROM Metro_Shop where user_name =?";
	    PreparedStatement pstmt=conn.prepareStatement(query);
	     pstmt.setString(1,user_name);
	       ResultSet rs=pstmt.executeQuery();
	       
	       while(rs.next()){
	    	   String user=rs.getString(1);
	    	   String pass=rs.getString(2);
	    	   if(!user.equals(null) || !pass.equals(null)) {
	    	   if(user.equals(user_name) && pass.equals(user_password)) {
	    		   	login=true;
	    	   }	    
	    	   }}
	      
	       }
	  catch(Exception e){
		  System.out.println("connection fail :" +e);
	  }
		
			finally {
				if (stmt != null) {
					try {
						stmt.close();
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
	 return login; 
	}
	
	
	public ArrayList<ArticlesDisplayBean> getArticles(){
		
		Connection conn=null;
		Statement stmt=null;
		ArrayList<ArticlesDisplayBean> list = new ArrayList<ArticlesDisplayBean>();
	    
	try {
		 conn=Dbconnection.getConnection();
		
		 String query="select * from articles";
	     stmt=conn.createStatement();
	    ResultSet rs=stmt.executeQuery(query);
	       
	       while(rs.next()){
	    	   
	    	   ArticlesDisplayBean db= new ArticlesDisplayBean(rs.getString("article_id"),rs.getString("name"),rs.getString("store"),rs.getString("color")); 
	    	   /*db.setArticle_id(rs.getString("article_id"));
	    	   db.setArticle_name(rs.getString("name"));
	    	   db.setStore_name(rs.getString("store"));
	    	   db.setArticle_color(rs.getString("color"));*/
	    	   list.add(db);
	    	     
	    	   }
		
		
		
	} catch(Exception e){
		  System.out.println("connection fail :" +e);
	  }
		
			finally {
				if (stmt != null) {
					try {
						stmt.close();
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
	return list;
}
	
	public boolean   isInsert(String id,String name,String store,String color) throws ClassNotFoundException, SQLException  {
		boolean insert=false;
		Connection conn=null;
		Statement stmt=null;
	     
	PreparedStatement prepstmt=null;
     
     try {
	 conn=Dbconnection.getConnection();
	 
	    String query="INSERT INTO Articles(Article_id,name,store,color) values(?,?,?,?)";
	    prepstmt= conn.prepareStatement(query);
	    
	      prepstmt.setString(1,id);
	      prepstmt.setString(2,name);
	      prepstmt.setString(3,store);
	      prepstmt.setString(4,color);
	      prepstmt.executeUpdate();
	       return insert=true;
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
	 return insert;
	}
	
	public EditPanelBean isRetrieve(String id) {
	boolean	retrieve=false;
	
	
	EditPanelBean ep=new EditPanelBean();
	
			
	Statement stmt=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	
	try {
		conn=Dbconnection.getConnection();
		
		String query="select * from articles where article_id=?";
		 pstmt = conn.prepareStatement(query);
		 pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery(); 
		while(rs.next()) {
			ep.setArticle_id(rs.getString("article_id"));
			ep.setArticle_name(rs.getString("name"));
		     ep.setStore_name(rs.getString("store"));
		     ep.setArticle_color(rs.getString("color"));
		return	ep;
		} 
	}catch(Exception e){
			  System.out.println("connection fail :" +e);
		  }
			
				finally {
					if (stmt != null) {
						try {
							stmt.close();
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
	
	return ep;
	}
	
	public boolean   deletArticles(String id) throws ClassNotFoundException, SQLException  {
		Connection conn=null;
		Statement stmt=null;
	     boolean delete=false;
	try {
		 conn=Dbconnection.getConnection();
		
		 String query="delete from articles where article_id=?";
	    PreparedStatement pstmt=conn.prepareStatement(query);
	     pstmt.setString(1,id);
	       pstmt.executeQuery();
	    		   	delete=true;
	       }
	  catch(Exception e){
		  System.out.println("connection fail :" +e);
	  }
		
			finally {
				if (stmt != null) {
					try {
						stmt.close();
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
	 return delete; 
	}
}
