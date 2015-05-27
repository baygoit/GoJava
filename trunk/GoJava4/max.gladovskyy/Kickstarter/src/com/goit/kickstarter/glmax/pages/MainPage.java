package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Kickstarter;
import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.model.DataSource;

public class MainPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private ArrayList<Category> categories = dataSource.getCategoriesList();
	private ArrayList<String> page = new ArrayList<String>();
	
	@Override
	public ArrayList<String> getPage() {
		page.add(dataSource.getSomeQuote());
		page.add("");
		page.add("Plese choose category from list below:");
		for (Category category : categories) {
			page.add(categories.indexOf(category)+1+") "+category.getName());
		}
		return page;
	}

}
