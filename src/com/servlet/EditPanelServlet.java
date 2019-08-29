package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daolayer.DaoLayer;
import com.daolayer.EditPanelBean;


public class EditPanelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("userId");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        HttpSession session = request.getSession(false);
		if(session.getAttribute("user") != null && session != null) {
			String user = (String) session.getAttribute("user");
			session.setAttribute("user", user);
		DaoLayer dc = new DaoLayer();
		try {
			EditPanelBean ep = dc.isRetrieve(id);
				if (ep !=null) {
					/*String id1=ep.getArticle_id();
					out.println(id1);*/
					request.setAttribute("ep", ep);
					RequestDispatcher ds = request.getRequestDispatcher("updatepage.jsp");
					ds.include(request,response);
				} else {
					out.println("<html><body><p>sorry...oops<p></body></html>");
					RequestDispatcher ds = request.getRequestDispatcher("Add_articles.jsp");
					ds.include(request,response);
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
       }	else {
    	   out.println("<html><body><p>sorry...please login first<p></body></html>");
    	   RequestDispatcher ds = request.getRequestDispatcher("index.jsp");
			ds.include(request,response);
		
       }
		
	}

}
