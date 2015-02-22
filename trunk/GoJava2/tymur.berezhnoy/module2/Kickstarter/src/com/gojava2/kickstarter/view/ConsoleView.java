package com.gojava2.kickstarter.view;

import com.gojava2.kickstarter.content.Category;
import com.gojava2.kickstarter.content.Project;
import com.gojava2.kickstarter.controller.CategoryController;
import com.gojava2.kickstarter.controller.ProjectController;
import com.gojava2.kickstarter.controller.QuoteController;

public class ConsoleView {
	
	private Category category;
	
	private QuoteController quoteController;
	private CategoryController categoryController;
	private ProjectController projectController;
	
	private final String title = "*** Super kickstarter ***";
	private String path;
	
	public ConsoleView(QuoteController quoteController, CategoryController categoryController,
				ProjectController projectController) {
		this.quoteController = quoteController;
		this.categoryController = categoryController;
		this.projectController = projectController;
	}
	
	public void displayHead() {
		System.out.println("\t" + title + "\n" + quoteController.getRandomQuote().getQuoteContent());
	}
	
	public void displayCategories() {
		path = "~ CATEGORIES/";
		System.out.println("\n" + path + "\n------------------------------------\nID Name");
		int i = 1;
		for(Category category: categoryController.getContent()) {
			System.out.println(i + ") " + category.getName());
			i++;
		}
		System.out.println("------------------------------------");
	}
	
	public void setCategoryPath(int i) { //TODO Name and logic
		category = categoryController.getSpecificContent(i - 1);
		path += category.getName().toUpperCase() + "/";
	}
	
	public void displayProjects() {
		int projectNumb = 1;
		StringBuilder shortInfo;
		
		System.out.println(path + "\n------------------------------------");
		for(Project project: projectController.getSpecificContent(category)) {
			shortInfo = new StringBuilder();
			shortInfo.append(projectNumb).append(") ").append(project.getName())
					 .append("\nDescription: ").append(project.getDescription())
					 .append("\nRequired amount: ").append(project.getRequiredAmount()).append(project.getSymbolDollar())
					 .append("\nTotal: ").append(project.getTotal()).append(project.getSymbolDollar())
					 .append("\nDays left: ").append(project.getDays());
			System.out.println(shortInfo + "\n------------------------------------");
			projectNumb++;
		}
	}
	
	public void displaySpecificProject(int i) {
		String newPath = path;
		
		int size = projectController.getSpecificContent(category).size();
		if(i > size) {
			System.out.println("- There are no projet at number: " + i);
			return;
		} else {
			Project project = projectController.getSpecificContent(category).get(i - 1);
			StringBuilder fullInfo = new StringBuilder();
			
			System.out.print(newPath += project.getName().toUpperCase() + "/"
						+ "\n------------------------------------");
			
			fullInfo.append("\nName: ").append(project.getName())
					.append("\nDescription: ").append(project.getDescription())
					.append("\nRequired amount: ").append(project.getRequiredAmount()).append(project.getSymbolDollar())
					.append("\nTotal: ").append(project.getTotal()).append(project.getSymbolDollar())
					.append("\nDays left: ").append(project.getDays())
					.append("\nBackers: ").append(project.getBackers())
					.append("\nStory: ").append(project.getStory())
					.append("\nLink to video: ").append(project.getLink());
			
				System.out.println(fullInfo + "\n------------------------------------");
		}
	}
}