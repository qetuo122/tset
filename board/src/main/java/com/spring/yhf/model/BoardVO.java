package com.spring.yhf.model;

import org.apache.ibatis.type.Alias;

@Alias("BoardVO")
public class BoardVO {

	private int id;
	private String img;
	private String title;
	private String con;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", img=" + img + ", title=" + title + ", con=" + con + "]";
	}
	
}
