package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String store=request.getParameter("store");
		String color=request.getParameter("color");
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        out.println(id);
        out.println(name);
	}

}
