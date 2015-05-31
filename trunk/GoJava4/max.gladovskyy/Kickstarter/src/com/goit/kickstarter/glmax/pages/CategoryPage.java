package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Project;

public class CategoryPage implements Page {
	private String categoryName;
	private ArrayList<Project> projects;
	private ArrayList<String> page = new ArrayList<String>();

	public CategoryPage(Runner runner, int categoryIndex) {
		this.categoryName = runner.getCategoryName(categoryIndex);
		projects = runner.getProjectsList(categoryIndex);
		page.add("You in category: " + categoryName);
		page.add("");
		page.add("Plese choose project from list below:");
		for (Project category : projects) {
			page.add(projects.indexOf(category)+1+") "+category.getName());
		}
		page.add("");
		page.add("0) Exit");
	}

	@Override
	public ArrayList<String> getPage() {
		return page;
	}

}
