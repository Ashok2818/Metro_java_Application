package com.servlet;

import java.io.IOException;
import com.daolayer.*;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRegisterBean user=new UserRegisterBean();
		user.setName(request.getParameter("First_Name"));
		user.setEmployeeid(request.getParameter("someid"));
		user.setUserarea(request.getParameter("store_area"));
		user.setUsercity(request.getParameter("store_city"));
		user.setUsercountry(request.getParameter("store_country"));
		user.setUseremail(request.getParameter("email"));
		user.setUserloginid(request.getParameter("user_name"));
		user.setUserloginpassword(request.getParameter("passcode"));
		user.setUserstorename(request.getParameter("store_name"));
		
		
          UserDaoLayer dl= new UserDaoLayer(user);
         // dl.setData();
         
          try {
              boolean flag=dl.isRegister();

      			if (flag == true) {
      				response.setContentType("text/html");
  		           PrintWriter out=response.getWriter();
                   out.println("<html><body><p>you have sucessfully registered <p></body></html>");
      				RequestDispatcher ds = request.getRequestDispatcher("RedirectTologin.jsp");
      				ds.include(request,response);
      			} else {
      				RequestDispatcher ds = request.getRequestDispatcher("user_register.jsp");
      				ds.include(request,response);
      			}
      		} catch (Exception e) {
      			e.printStackTrace();
      		} 
	}	
	
}

