package com.kickstarter.view;

import java.util.Collections;
import java.util.List;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;

public class MainPage {

	private Quote quote;
	private List<Category> categories;
	private Category currentCategory;
	private List<Project> projects;

	public MainPage() {
		categories = Collections.emptyList();
		projects = Collections.emptyList();
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void update() {

		System.out.println("\"" + quote.getText() + "\" - " + quote.getAuthor());

		System.out.print("\nCategories: | ");

		for (int i = 0; i < categories.size(); i++) {
			System.out.print("" + i + ". " + categories.get(i).getName() + " | ");
		}

		if (currentCategory != null) {
			System.out.println("\nCurrent category: " + currentCategory.getName());
		}

		if (projects.isEmpty()) {
			System.out.println("No projects in this category");
		} else {
			for (Project project : projects) {
				System.out.println(project);
			}
		}

	}

}
