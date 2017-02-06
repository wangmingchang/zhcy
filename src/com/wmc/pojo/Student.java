package com.wmc.pojo;

public class Student {

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别，1：女，2：男
	 */
	private int sex;

	/**
	 * 父亲姓名
	 */
	private String fatherName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", fatherName=" + fatherName + "]";
	}

}
