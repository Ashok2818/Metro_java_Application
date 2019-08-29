package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class logoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
       
			HttpSession session = request.getSession(false);
			if(session.getAttribute("user") != null && session != null) {
				String name1 = (String) session.getAttribute("user");
				/* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				 response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			        response.setDateHeader("Expires", 0); */
				  session.invalidate();
				  RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
				  rd.forward(request, response);
				
				}else {
					  out.println("<html><body><p>sorry...please login first<p></body></html>");
			    	   RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
						ds.include(request, response);
				}
			}
		    
	}


