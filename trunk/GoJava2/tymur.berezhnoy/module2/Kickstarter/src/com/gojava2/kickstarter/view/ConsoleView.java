package com.gojava2.kickstarter.view;

import static java.lang.System.out;

import java.util.List;
import java.util.Set;

import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.Quote;

public class ConsoleView {

	private final String TITLE = "*** Super kickstarter ***";

	public void displayTitle() {
		out.println("\t" + TITLE);
	}
	
	public void display(Quote quote) {
		StringBuilder result = new StringBuilder();
		
		result.append("\"").append(quote.getContent()).append("\"")
					 .append(quote.getCopyrightSymbol()).append(" ").append(quote.getAuthor());
		out.println(result);
	}
	
	public void display(Set<Category> categories) {
		out.println("\n" + "------------------------------------\nID Name");
		
		int i = 1;
		for (Category category : categories) {
			out.println(i + ") " + category.getName());
			i++;
		}
		out.println("------------------------------------");
	}
	
	public void display(List<Project> projects) {
		StringBuilder result;

		for (int i = 0; i < projects.size(); i++) {
			result = new StringBuilder();
			result.append(i + 1).append(") ").append(projects.get(i).getName())
					 .append("\nDescription: ").append(projects.get(i).getDescription())
					 .append("\nRequired amount: ").append(projects.get(i).getRequiredAmount()).append(projects.get(i).getSymbolDollar())
					 .append("\nTotal: ").append(projects.get(i).getTotal()).append(projects.get(i).getSymbolDollar())
					 .append("\nDays left: ").append(projects.get(i).getDays());
			out.println(result + "\n------------------------------------");
		}
	}
	
	public void display(Project project) {
		
		StringBuilder result = new StringBuilder();
		out.print("\n------------------------------------");
		
		result.append("\nName: ").append(project.getName())
				.append("\nDescription: ").append(project.getDescription())
				.append("\nRequired amount: ").append(project.getRequiredAmount()).append(project.getSymbolDollar())
				.append("\nTotal: ").append(project.getTotal()).append(project.getSymbolDollar())
				.append("\nDays left: ").append(project.getDays())
				.append("\nBackers: ").append(project.getBackers())
				.append("\nStory: ").append(project.getStory())
				.append("\nLink to video: ").append(project.getLink());
		
		out.println(result + "\n------------------------------------");
	}
	
	public void displaySelectOption(int level) {
		switch(level) {
			case 1: 
				out.print("[0 - exit; 1 - * - selec category;]\n> ");
				break;
			case 2:
				out.print("[0 - to categories; 1 - * - selec project;]\n> ");
				break;
			case 3: 
				out.print("[0 - to projects;]\n> ");
				break;
			default :
				break;
		}
	}
}