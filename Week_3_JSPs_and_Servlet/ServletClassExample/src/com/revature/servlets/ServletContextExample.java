package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextExample extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println(getServletName() + " - is the servlet name");
		
		String firstValue = getServletConfig().getServletContext().getInitParameter("url");
		
		System.out.println("Url: " + firstValue); 
	}
	
		
	
}
