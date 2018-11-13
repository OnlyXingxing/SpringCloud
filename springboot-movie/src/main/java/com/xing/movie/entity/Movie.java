package com.xing.movie.entity;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Movie implements Serializable{
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String nameEn;
	//上映时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd", timezone = "GMT+8")
	private Date updatetime;
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
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
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", nameEn=" + nameEn + ", updatetime=" + updatetime + "]";
	}
	public Movie(String name, String nameEn, Date updatetime) {
		super();
		this.name = name;
		this.nameEn = nameEn;
		this.updatetime = updatetime;
	}
	public Movie() {
		super();
	}
	
}
