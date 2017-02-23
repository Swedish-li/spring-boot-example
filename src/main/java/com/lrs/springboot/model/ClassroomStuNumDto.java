package com.lrs.springboot.model;

public class ClassroomStuNumDto {
	private int cid;
	private String cname;
	private String grade;
	private int snum;
	
	public ClassroomStuNumDto(int cid, String cname, String grade, int snum) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
		this.snum = snum;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	
}
