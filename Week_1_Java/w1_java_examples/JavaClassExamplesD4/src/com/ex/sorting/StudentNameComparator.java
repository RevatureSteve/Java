package com.ex.sorting;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		/*
		 * Compares two strings lexicographically. 
		 * The comparison is based on the Unicode value of each character in the strings.
		 */
		return o1.getName().compareTo(o2.getName());
	}

}
