package com.kickstarter.view;
import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;

public class View {	
	Out whereToOut;
	private final String GREATING = " Welcome to Kickstarter";
	
	public View(Out whereToOut) {
		this.whereToOut = whereToOut;
	}
	
	public void displayWelcome() {
		whereToOut.outPut(GREATING + "\n"
				+ "  *** *** *** *** *** \n");
	}
	
	public void displayQuote(String quote) {
		whereToOut.outPut(quote + "\n  *** *** *** *** *** \n");
	}
	
	public void select(int i) {
		if (i == 1) {
			whereToOut.outPut("\n" + "Please select category: ");
		} else if (i == 2) {
			whereToOut.outPut("\n" + "(Press \"0\" - back to categories.)"
								+ "\n" + "Select project: ");
		} else if (i == 3) {
			whereToOut.outPut("Press \"0\"  - back to projects: ");
		}
	}
	
	
	public void incorrect() {
		whereToOut.outPut("Incorrect number. Please try again.");
	}
	
	public void displayListCategories(List<Сategory> categories) {
		int i = 1;
		for (Сategory сategory: categories) {
			whereToOut.outPut(i + ". " + сategory.getName() + "\n");
			i++;
		}
	}
	
	public void displaySelectedCategory(Сategory category) {
		whereToOut.outPut("\nYour choise: " + category.getName());
		whereToOut.outPut("\n---- Here are the projects ----\n");
	}

		
		public void displayProjects(List<Project> projects) {		
		StringBuilder stringResult;
		for (int i = 0; i < projects.size(); i++) {
			stringResult = new StringBuilder();
			stringResult.append(i + 1).append(". ")
					.append(projects.get(i).getName()).append("\n")
					.append("Description:        ").append(projects.get(i).getDescription())
					.append("\n").append("Required Amount:    ").append(projects.get(i).getRequiredAmount()).append("$")
					.append("\n").append("Total:              ").append(projects.get(i).getTotal()).append("$")
					.append("\n").append("Days:               ").append(projects.get(i).getDays());
			whereToOut.outPut(stringResult + "\n"
					+ "----------------------------------" + "\n");
		}
	}
	
	public void displayProject(Project project) {
		StringBuilder stringResult = new StringBuilder();
		stringResult.append(project.getName()).append("\n")
					.append("Description:        ").append(project.getDescription())
					.append("\n").append("Required Amount:    ").append(project.getRequiredAmount()).append("$")
					.append("\n").append("Total:              ").append(project.getTotal()).append("$")
					.append("\n").append("Days:               ").append(project.getDays())
					.append("\n").append("History:            ").append(project.getHistory())
					.append("\n").append("URL:                ").append(project.getUrl());
		whereToOut.outPut("\n"+ stringResult + "\n"
				+ "--------------------------------" + "\n");
	}		
}