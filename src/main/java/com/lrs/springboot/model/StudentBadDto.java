package com.lrs.springboot.model;

public class StudentBadDto {
	private Student stu;
	private Classroom clz;

	public StudentBadDto() {
		super();
	}

	public StudentBadDto(Student stu, Classroom clz) {
		super();
		this.stu = stu;
		this.clz = clz;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Classroom getClz() {
		return clz;
	}

	public void setClz(Classroom clz) {
		this.clz = clz;
	}

}
