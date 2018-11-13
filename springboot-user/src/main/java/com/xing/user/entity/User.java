package com.xing.user.entity;

import java.io.Serializable;

public class User implements Serializable{
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String nameEn;
	private int age;
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
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nameEn=" + nameEn + ", age=" + age + "]";
	}
	public User(String name, String nameEn, int age) {
		super();
		this.name = name;
		this.nameEn = nameEn;
		this.age = age;
	}
	public User() {
		super();
	}
	
}
