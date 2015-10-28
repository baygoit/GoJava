package com.anna.kickstarter;

public class BusinessIdea {
	String name;
	String description;
	int price;
	Category category;
	
	
	
	
	public BusinessIdea(String name, String description, int price, 
			Category category) {

		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
