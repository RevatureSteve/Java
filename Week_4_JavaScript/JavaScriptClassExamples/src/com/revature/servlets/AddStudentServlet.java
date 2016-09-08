package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.Student;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost of AddStudentServlet");
		
		//Grab user Session
		HttpSession session = req.getSession();
		
		
		//Create a Collection to store all the students
		List<Student> studentList = new ArrayList<>();
		
		//Did user have a session already? add that collection first
		if(session.getAttribute("listOfStudents") != null){
			studentList.addAll( (List<Student>) session.getAttribute("listOfStudents"));
		}
		
		String[] studentIds = req.getParameterValues("id"); //Pull all parameters with the name of id
		String[] studentNames = req.getParameterValues("name"); //all parameters with name of name
		String[] studentMajors = req.getParameterValues("major"); //all parameters with name of major
		
		
		for(int i = 0; i < studentIds.length; i++){
			//Use the array of ids, names, and majors to construct each student
			//Then we are adding them to the collection of students
			studentList.add(new Student(Integer.parseInt(studentIds[i]), studentNames[i],studentMajors[i]));
		}
		
		//Reset the list of students
		session.setAttribute("listOfStudents", studentList);
		
		//Redirect to display students to client
		resp.sendRedirect("displayStudents.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
	
}
