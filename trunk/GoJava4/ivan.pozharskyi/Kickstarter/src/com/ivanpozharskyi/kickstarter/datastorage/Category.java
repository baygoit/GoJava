package com.ivanpozharskyi.kickstarter.datastorage;

public class Category {
	private static int count = 0;
	private String name;
	private int id;

	public Category(String name) {
		this.id = ++count;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getCategoryId() {
		return id;
	}

	@Override
	public String toString() {
		return ("[id" + id + "]: " + name);
	}

}
