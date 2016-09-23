package com.ex.day5.jpa;

import java.util.List;

public interface StudentService {
	
	public void addStudent(Student student);
	public List<Student> findAllStudents();
	public Student findStudentByName(String name);

}
