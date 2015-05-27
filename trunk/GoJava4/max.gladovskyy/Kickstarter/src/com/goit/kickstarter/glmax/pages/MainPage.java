package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Kickstarter;
import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Quote;
import com.goit.kickstarter.glmax.model.DataSource;
import com.goit.kickstarter.glmax.view.Output;

public class MainPage implements Page {
	
	private ArrayList<String> page = new ArrayList<String>();
	
	
	public MainPage(Runner runner) {
		page.add(runner.getSomeQoute());
		page.add("");
		page.add("Plese choose category from list below:");
		int index = 1;
		for (Category category : runner.getCategories()) {
			page.add(index+") "+ category.getName());
		}
	}

	@Override
	public ArrayList<String> getPage() {
		return page;
	}
}
