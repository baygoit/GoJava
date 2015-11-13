package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {

	public void print(Quote quote) {
		System.out.println("Quote: " + quote.getText() + " " + quote.getAuthor());
	}

	public void print(List<Category> categories) {
		System.out.println("All categories:");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println((i + 1) + " : " + category.getName());
		}
	}
	
	public void print(Category category) {
		System.out.println("Category: " + category.getName());
	}

	public void print(String string) {
		System.out.println(string);
	}

	public void print(Category category, List<Project> projects) {
		this.print(category);
		System.out.println("Category Projects:");
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			System.out.println((i + 1) + " : " + project.getName());
			System.out.println("\t Short description: " + project.getShortDescription());
			System.out.println("\t Required amount: " + project.getRequiredAmount() / (double) 10);
			System.out.println("\t Gathered amount: " + project.getGatheredAmount() / (double) 10);
			System.out.println("\t Days left: " + project.getDaysLeft());
		}
		
	}

	public void print(Project project) {
		System.out.println("Project: " + project.getName());
		System.out.println("\t Short description: " + project.getShortDescription());
		System.out.println("\t Required amount: " + project.getRequiredAmount() / (double) 10);
		System.out.println("\t Gathered amount: " + project.getGatheredAmount() / (double) 10);
		System.out.println("\t Days left: " + project.getDaysLeft());
		System.out.println("\t History: " + project.getHistory());
		System.out.println("\t Video: " + project.getVideoUrl());
		System.out.println("\t Q&As: " + project.getQuestionsAndAnswers());

	}
}
