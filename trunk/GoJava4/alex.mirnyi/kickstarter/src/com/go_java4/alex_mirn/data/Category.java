package com.go_java4.alex_mirn.data;


public class Category {
	private int id;
	private String name;

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

}
