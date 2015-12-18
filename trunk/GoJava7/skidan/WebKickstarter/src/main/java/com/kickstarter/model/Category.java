package com.kickstarter.model;

public class Category {

	private String title;
	private int id;

	public Category() {

	}

	public Category(String title, int id) {
		this.title = title;
		this.id = id;

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

	@Override
	public String toString() {
		return title;
	}

}
