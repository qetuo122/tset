package com.spring.android.model;

import org.apache.ibatis.type.Alias;

@Alias("ListVO")
public class ListVO {

	private int id;
	private String image;
	private String title;
	private String con;
	private String category;
	
		
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
		return "ListVO [id=" + id + ", image=" + image + ", title=" + title + ", con=" + con + ", category=" + category + "]";
	}
	
	
	
}
