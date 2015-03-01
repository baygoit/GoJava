package com.kickstarter.view;
import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;

public class ConsoleView {	
	private final String GREATING= " Welcome to Kickstarter";
	
	public void displayWelcome() {
		System.out.println(GREATING + "\n"
				+ "  *** *** *** *** *** ");
	}
	
	public void displayQuote(String quote) {
		System.out.println(quote + "\n  *** *** *** *** *** ");
	}
	
	public void displayListCategories(List<Сategory> categories) {
		int i = 1;
		for (Сategory сategory: categories) {
			System.out.println(i + ". " + сategory.getName());
			i++;
		}
	}
	
	public void displaySelectedCategory(Сategory category) {
		System.out.println("Your choise: " + category.getName());
	}

	public void displayProjectsOfCategory(List<Project> projects) {		
		System.out.println("\n---- Here are the projects ----");
		StringBuilder stringResult;
		
		for (int i = 0; i < projects.size(); i++) {
			stringResult = new StringBuilder();
			stringResult.append(i + 1).append(". ")
					.append(projects.get(i).getName()).append("\n")
					.append("Description:        ").append(projects.get(i).getDescription())
					.append("\n").append("Required Amount:    ").append(projects.get(i).getRequiredAmount()).append("$")
					.append("\n").append("Total:              ").append(projects.get(i).getTotal()).append("$")
					.append("\n").append("Days:               ").append(projects.get(i).getDays());
			System.out.print(stringResult + "\n"
					+ "----------------------------------" + "\n");
		}
	}
	
	public void displayCurrentProject(Project project) {
		StringBuilder stringResult = new StringBuilder();
		stringResult.append(project.getName()).append("\n")
					.append("Description:        ").append(project.getDescription())
					.append("\n").append("Required Amount:    ").append(project.getRequiredAmount()).append("$")
					.append("\n").append("Total:              ").append(project.getTotal()).append("$")
					.append("\n").append("Days:               ").append(project.getDays())
					.append("\n").append("History:            ").append(project.getHistory())
					.append("\n").append("URL:                ").append(project.getUrl());
		System.out.print("\n"+ stringResult + "\n"
				+ "--------------------------------" + "\n");
	}		
}