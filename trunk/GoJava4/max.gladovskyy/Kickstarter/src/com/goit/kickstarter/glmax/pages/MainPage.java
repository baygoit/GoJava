package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Category;

public class MainPage implements Page {
	
	private ArrayList<String> page = new ArrayList<String>();
	
	
	public MainPage(Runner runner) {
		page.add(runner.getSomeQoute());
		page.add("");
		page.add("Plese choose category from list below:");
		int index = 1;
		ArrayList<Category> categories = runner.getCategories();
		for (Category category : categories) {
			page.add(categories.indexOf(category)+1+") "+category.getName());
		}
	}

	@Override
	public ArrayList<String> getPage() {
		return page;
	}
}
