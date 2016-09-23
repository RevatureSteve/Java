package com.ex.day5.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentServiceImpl;

	@RequestMapping("viewAll")
	public ModelAndView viewAllStudents() {
		System.out.println("viewAll");
		return new ModelAndView("showStudents", "studentList", studentServiceImpl.findAllStudents());
	}

	@RequestMapping("viewOne/{name}")
	public ModelAndView viewOneStudent(@PathVariable String name) {
		return new ModelAndView("showStudentByName", "student", studentServiceImpl.findStudentByName(name));
	}
	
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student){
		
//		student.setName("steve");
//		student.setGpa(5.9);
		studentServiceImpl.addStudent(student);
		return viewAllStudents();
	}

}
