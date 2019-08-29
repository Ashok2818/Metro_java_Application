package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import com.daolayer.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ArticlesAddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("Article_id");
		String name = request.getParameter("Article_Name");
		String store = request.getParameter("Store_Name");
		String color = request.getParameter("color");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
       
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") != null && session != null) {
			String user = (String) session.getAttribute("user");
			
		DaoLayer dc = new DaoLayer();
		try {
			boolean status = dc.isInsert(id, name, store, color);
				if (status == true) {
					out.println("<html><body><p>you have sucessfully add articles<p></body></html>");

				} else {
					out.println("<html><body><p>sorry...oops<p></body></html>");
					RequestDispatcher ds = request.getRequestDispatcher("Add_articles.jsp");
					ds.include(request,response);
				}
			}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
       }	else {
    	   out.println("<html><body><p>sorry...please login first<p></body></html>");
    	   RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
			ds.include(request,response);
		
       }
			
	}
}
