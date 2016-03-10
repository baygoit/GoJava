package com.goit.logic;

import java.util.ArrayList;

public class Menu {
	private ArrayList<String> categories = new ArrayList<>();
	private String quote;

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuote() {
		return quote;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void addCategory(String categoryName) {
		categories.add(categoryName);
	}

	public String getCategory(int index) {
		return categories.get(index);
	}
	
	public int getAmountCategories(){
		return categories.size();
	}
}
