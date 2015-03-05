package com.goit.kickstarter.model;

public class Category {
	private String title;
	private int id;
	
	public Category(String title){
		this.title=title;
	}
	
	public Category(String title, int id){
		this.title=title;
		this.id=id;
	}
	
	public Category(int categoryId) {
		this.id=categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
