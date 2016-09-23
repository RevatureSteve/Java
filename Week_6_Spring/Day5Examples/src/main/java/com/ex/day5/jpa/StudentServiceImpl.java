/**
 * 
 */
package com.ex.day5.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jeff
 *
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student findStudentByName(String name) {
		return studentDao.findStudentByName(name);
	}

}
