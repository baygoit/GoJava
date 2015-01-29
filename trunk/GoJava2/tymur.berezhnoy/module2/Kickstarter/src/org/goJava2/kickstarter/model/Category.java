package org.goJava2.kickstarter.model;

public class Category {
	
	private String name;
	
	public Category(String name) {
		this.name = name;
	}
	
	public void setNewName(String name) {
		this.name = name;
	}
	
	public String getNameCategory() {
		return name;
	}
}