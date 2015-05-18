package com.go_java4.alex_mirn.data;

public class Category {
	private int id;
	private String name;

	private static int count = 0;

	public Category(String name) {
		this.id = ++count;
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
