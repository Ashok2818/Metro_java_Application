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
import javax.servlet.http.HttpSession;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("Id");
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
		
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") != null && session != null) {
			String name1 = (String) session.getAttribute("user");
			
		DaoLayer dc = new DaoLayer();
		try {
			boolean status = dc.deletArticles(id);

			if (status==true) {
                out.println("<html><body><p>you have sucessfully delete article<p></body></html>");
		

			} else {			
		          out.println("<html><body><p>sorry...oops<p></body></html>");
		          RequestDispatcher ds = request.getRequestDispatcher("Delete_articles.jsp");
					ds.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			 out.println("<html><body><p>sorry...please login first<p></body></html>");
	    	   RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
				ds.include(request, response);
		}
		
		
	
	}

}
