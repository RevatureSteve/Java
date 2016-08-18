package com.ex.sorting;

import java.util.Comparator;

public class StudentDobComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		/*
		 * Compares this date to another date. 
		 * The comparison is primarily based on the date, 
		 * from earliest to latest. 
		 * 
		 * It is "consistent with equals", as defined by Comparable. 
		 */
		return o1.getDob().compareTo(o2.getDob());
	}

}
