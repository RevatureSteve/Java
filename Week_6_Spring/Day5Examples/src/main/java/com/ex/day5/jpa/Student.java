package com.ex.day5.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {

	@Id
	@Column(name="s_id")
	@SequenceGenerator(allocationSize=1,name="studentSeq",sequenceName="student_seq")
	@GeneratedValue(generator="studentSeq",strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(unique=true)
	private String name;
	private Double gpa;

	public Student() {
		super();
	}

	public Student(String name, Double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

}
