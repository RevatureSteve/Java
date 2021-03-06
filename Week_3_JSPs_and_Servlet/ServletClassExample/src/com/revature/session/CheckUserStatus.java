package com.revature.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserStatus extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//Using short-circuit
		if(session.getAttribute("user") != null && session.getAttribute("user").equals("true")){
			System.out.println("Yes user is logged on.");
		}else{
			System.out.println("No user is not logged on.");
		}
	}

	
}
