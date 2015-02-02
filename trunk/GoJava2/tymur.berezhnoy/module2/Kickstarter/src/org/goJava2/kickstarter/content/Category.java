package org.goJava2.kickstarter.content;

public class Category {
	
	private String name;
	
	public Category(String name) {
		this.name = name;
	}
	
	public void setNewName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}