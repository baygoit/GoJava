package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Project;

public class CategoryPage implements Page {
	private String categoryName;
	private ArrayList<Project> projects;
	private ArrayList<String> page = new ArrayList<String>();

	public CategoryPage(Runner runner) {
		this.categoryName = runner.getCategoryName();
		projects = runner.getProjectsList();
		page.add("You in category: " + categoryName);
		page.add("");
		page.add("Plese choose project from list below:");
		for (Project project : projects) {
			page.add(projects.indexOf(project)+1+") "+project.getName());
		}
		page.add("");
		page.add("0) Exit");
	}

	@Override
	public ArrayList<String> getPage() {
		return page;
	}

}
