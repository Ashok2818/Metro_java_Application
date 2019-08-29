package com.servlet;

import java.io.IOException;
import com.daolayer.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RefreshServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") != null && session != null) {
			String name1 = (String) session.getAttribute("user");

		
		DaoLayer dc = new DaoLayer();
		try {

			ArrayList<ArticlesDisplayBean> list = dc.getArticles();
			request.setAttribute("list", list);
			RequestDispatcher rs = request.getRequestDispatcher("Article_diplay.jsp");
			rs.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 }	else {
	    	   out.println("<html><body><p>sorry...please login first<p></body></html>");
	    	   RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
				ds.include(request, response);
			}

	}
}
