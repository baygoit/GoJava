package org.goJava2.kickstarter.view;

import java.util.ArrayList;

import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.Project;
import org.goJava2.kickstarter.model.Quote;

public class View {
	
	private final String title = "*** Super kickstarter ***";
	private String path;
	public void displayHead(Quote quote) {
		System.out.println("\t" + title + "\n" + quote.getContent());
	}
	
	public void displayCategories(ArrayList<Category> categories) {
		path = "~ CATEGORIES/";
		System.out.println("\n" + path + "\n№ Name");
		int i = 1;
		for(Category category: categories) {
			System.out.println(i + ". " + category.getName());
			i++;
		}
	}
	
	public void displaySelectedCategory(Category category) {
		path += category.getName().toUpperCase() + "/";
	}
	
	public void displayProjects(ArrayList<Project> projects) {
		int i = 1;
		System.out.println(path);
		for(Project project: projects) {
			System.out.println(i + ") " + project.getName() + "\n" + project.toString());
			i++;
		}
	}
	
	public void displayCurrentProject(Project project) {
		String newPath = path;
		newPath += project.getName().toUpperCase() + "/";
		System.out.println(newPath + "\nName: " + project.getName() + "\n" + project.toString());
	}
}