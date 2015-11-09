package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {
	
	public void print(Quote quote) {
		System.out.println(quote.getText() + "\n     " + 	quote.getAuthor());
		}
	
	public void printCategories(List<Category> categories) {
		System.out.println("\n_________________________________________");
		System.out.println("0: for exit");
		for(int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}	
	}
	
	public void printShort(Project project) {
		System.out.println("Name: " + project.getName());
    	System.out.println("Short description: " + project.getDescription());
    	System.out.println("Goal: " + project.getGoal());
    	System.out.println("Pledged: " + project.getPledged());
    	System.out.println("Days to go: " + project.getDaysToGo());    	
	}
	
	public void printFull(Project project) {
		printShort(project);
		System.out.println("History: " + project.getHistory());
    	System.out.println("Link to the demo video: " + project.getLink());
    	System.out.println("Questions/Answers: " + project.getQuestions());
	}
	
	public void printProjects(List<Project> projects) {
		System.out.println("_________________________________________");
		System.out.println("\n0: for return to list of categories");
		for(int i = 0; i < projects.size(); i++){			
			System.out.println("\n" + (i+1) + ":");
			printShort(projects.get(i));
		}	
	}
	
}
