package com.servlet;

import java.io.IOException;
import com.daolayer.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class First extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_name");
		String user_pass = request.getParameter("user_password");
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();

		DaoLayer dc = new DaoLayer();
		try {
			boolean status = dc.loginProcess(user_id, user_pass);

			if (status) {
                 
				HttpSession session =request.getSession();
				session.setAttribute("user_id", user_id);
				
				ArrayList<ArticlesDisplayBean> list = dc.getArticles();
				request.setAttribute("list", list);
				RequestDispatcher rs = request.getRequestDispatcher("Article_diplay.jsp");
				rs.forward(request, response);

			} else {
              out.println("<html><body><p>the user name or password you entered was wrong<p></body></html>");
				RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
				ds.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
