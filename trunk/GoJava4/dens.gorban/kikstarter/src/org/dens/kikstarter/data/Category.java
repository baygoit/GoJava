package org.dens.kikstarter.data;

public class Category {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}
	
	

}
