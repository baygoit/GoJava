package ua.com.goit.gojava7.kickstarter.console;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {
	public void print(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}
	
	public void printCategories(ArrayList<Category> categories) {
		System.out.println(categories.size() + 
				" diverse categories. Thousands of amazing projects.");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println((i + 1) + ". " + category.getName());
		}
	}
	
	public void print(Category category) {
		System.out.println("Category: " + category.getName());
	}
	
	public void printProjectsInCategory(ArrayList<Project> projects) {
		System.out.println("Projects in selected category:");
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			System.out.println(project.getName() + ", " + project.getSummary() + ", $"
					+ project.getPledged() + " pledged of goal" + project.getGoal() +  ", " 
					+ project.getDaysToGo() + " days to go.");
		}
	}

	public void print (String string) {
		System.out.println(string);
	}

	public void print(Category category, List<Project> projects) {
		this.print(category);
		System.out.println("Projects in category:");
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			System.out.println((i + 1) + ". " + project.getName());
			System.out.println("\t Summary: " + project.getSummary());
			System.out.println("\t Goal: " + project.getGoal());
			System.out.println("\t Pledged: " + project.getPledged());
			System.out.println("\t Days to go: " + project.getDaysToGo());
		}
	}
	
	public void print(Project project) {
		System.out.println("Project: " + project.getName());
		System.out.println("\t Info: " + project.getInfo());
		System.out.println("\t Goal: " + project.getGoal());
		System.out.println("\t Pledged: " + project.getPledged());
		System.out.println("\t Days to go: " + project.getDaysToGo());
		System.out.println("\t History of the project: " + project.getHistory());
		System.out.println("\t Video link: " + project.getVideo());
		System.out.println("\t Q&A: " + project.getQuestions());
	}
}
