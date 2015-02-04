package org.goJava2.kickstarter.view;

import java.util.List;

import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Project;
import org.goJava2.kickstarter.controller.CategoryController;
import org.goJava2.kickstarter.controller.ProjectController;
import org.goJava2.kickstarter.controller.QuoteController;
import org.goJava2.kickstarter.factory.StorageFactory;
import org.goJava2.kickstarter.model.ProjectStorage;

public class View {
	
	private Category category;
	
	private QuoteController quoteController;
	private CategoryController categoryController;
	private ProjectController projectController;
	
	private final String title = "*** Super kickstarter ***";
	private String path;
	
	public View(QuoteController quoteController, CategoryController categoryController, ProjectController projectController) {
		this.quoteController = quoteController;
		this.categoryController = categoryController;
		this.projectController = projectController;
	}
	
	public void displayHead() {
		System.out.println("\t" + title + "\n" + quoteController.passRandomQuoteToView().getQuoteContent());
	}
	
	public void displayCategories() {
		path = "~ CATEGORIES/";
		System.out.println("\n" + path + "\n№ Name");
		int i = 1;
		for(Category category: categoryController.getContent()) {
			System.out.println(i + ". " + category.getName());
			i++;
		}
	}
	
	public void displaySpecificCategory(int i) {
		category = categoryController.getSpecificContent(i - 1);
		path += category.getName().toUpperCase() + "/";
		System.out.println(path);
	}
	
	public void displayProjects() {
		int i = 1;
		for(Project project: projectController.getSpecificContent(category)) {
			System.out.println(i + ") " + project.getName() + "\n" + project.getShortInfo());
			i++;
		}
	}
	
	public void displaySpecificProject(int i) {
		String newPath = path;
		ProjectStorage projectStorage = new StorageFactory().getProjectStorage();
		List<Project> projects = projectStorage.getSpecificContent(category);
		if(i > projects.size()) {
			System.out.println("- There are no projet at number: " + i);
			return;
		}
		newPath += projects.get(i - 1).getName().toUpperCase() + "/";
		System.out.println(newPath + "\nName: " + projects.get(i - 1).getName() + "\n" + projects.get(i - 1).getFullInfo());
	}
}