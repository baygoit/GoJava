package org.goJava2.kickstarter.view;

import java.util.ArrayList;
import org.goJava2.kickstarter.controller.ControllerApp;
import org.goJava2.kickstarter.model.Category;
import org.goJava2.kickstarter.model.GeneralStorage;
import org.goJava2.kickstarter.model.Project;
import org.goJava2.kickstarter.model.Quote;
import org.goJava2.kickstarter.model.QuoteStorage;

public class Kickstarter {
	
	private final String title = "**** Super duper Kickstarter ****";
	private ControllerApp contentManager;
	private ArrayList<Category> categories;
	private ArrayList<Project> projects;
	private Category category;
	private Project project;
	
	public void showQuote() {
		contentManager = new ControllerApp(new QuoteStorage(new ArrayList<Quote>()), new GeneralStorage());
		System.out.println("\t" + title);
		System.out.println("\n" + contentManager.getQuote().getContent());
	}
	
	public void showCategorys() {
		categories = contentManager.getCategories();
		System.out.println("\n<- Categories ->\n№ Name");
		int i = 1;
		for(Category category: categories) {
			System.out.println(i + " " + category.getNameCategory());
			i++;
		}
	}
	
	public void selectCategry(int i) {
		category = categories.get(i - 1);
		System.out.println("- You've chose: " + category.getNameCategory());
	}
	
	public void showSpecificProj() {
		projects = contentManager.getSpecificProjetcs(category);
		int i = 1;
		for(Project project: projects) {
			System.out.println("-----------------------------------");
			System.out.println(i+ ". " + project.toString());
			i++;
		}
		System.out.println("-----------------------------------");
	}
	
	public void selectProject(int i) {
		project = projects.get(i - 1);
		System.out.println(project.toString());
	}
}