package com.lrs.springboot.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ClassroomDto {
	private int id;
	private String name;
	private String grade;
	private List<Student> stus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<Student> getStus() {
		return stus;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
