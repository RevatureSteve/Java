package com.ex.day5.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long>{
	
	public Student findStudentByName(String name);

}
