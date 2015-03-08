package com.kickstarter.model;

import java.util.LinkedList;
import java.util.List;

public class InMemoryCategories implements Categories{
	
	private List<Сategory> categories = new LinkedList<Сategory>();
	
	@Override
	public void add(Сategory category) {
		categories.add(category);
	}
	
	@Override
	public List<Сategory> getCategories() {
		return categories;
	}
	
	@Override
	public Сategory get(int index) {
		return categories.get(index - 1); 
	}
	
	@Override
	public int size() {
		return categories.size();
	}

}