package com.spring.model;

public class ListVO {

	private int id;
	private String image;
	private String title;
	private String con;
	
	
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
	
	public ListVO(int id, String image, String title, String con) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.con = con;
	}
	
	@Override
	public String toString() {
		return "ListVO [id=" + id + ", image=" + image + ", title=" + title + ", con=" + con + "]";
	}
	
}
