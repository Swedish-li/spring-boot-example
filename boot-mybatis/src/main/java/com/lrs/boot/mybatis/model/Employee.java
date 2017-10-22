package com.lrs.boot.mybatis.model;

/**
 * 数据模型
 * 
 * @author Swedish-li
 *
 */

public class Employee {

	public int id;

	public String name;

	public String state;

	public String city;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", state=" + state + ", city=" + city + "]";
	}

}
