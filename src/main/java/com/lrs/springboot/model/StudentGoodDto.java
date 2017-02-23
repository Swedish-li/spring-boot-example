package com.lrs.springboot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StudentGoodDto {
	private int sid;
	private String sname;
	private int clzId;
	private String clzName;
	private String grade;

	public StudentGoodDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentGoodDto(int sid, String sname, int clzId, String clzName, String grade) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.clzId = clzId;
		this.clzName = clzName;
		this.grade = grade;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getClzId() {
		return clzId;
	}

	public void setClzId(int clzId) {
		this.clzId = clzId;
	}

	public String getClzName() {
		return clzName;
	}

	public void setClzName(String clzName) {
		this.clzName = clzName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
