package com.sergiisavin.kickstarter;

public class Category {

	private String categoryName;
	
	public Category(String categoryName){
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString(){
		return categoryName;
	}
}
