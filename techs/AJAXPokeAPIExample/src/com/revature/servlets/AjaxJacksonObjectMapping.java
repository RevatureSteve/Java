package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Person;

/**
 * Servlet implementation class AjaxJacksonObjectMapping
 */
@WebServlet("/getBetterJSON")
public class AjaxJacksonObjectMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person john = new Person("John", 32);
		
		//ObjectMapper will convert Java Objects to Strings
		ObjectMapper mapper = new ObjectMapper(); 
		String johnJSON = mapper.writeValueAsString(john);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
