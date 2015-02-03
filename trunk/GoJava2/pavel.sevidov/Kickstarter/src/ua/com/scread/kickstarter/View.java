package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class View {

	public View() {
		
	}
	
	public void greed() {
		QuoteGenerator quote = new QuoteGenerator(new Random());
		System.out.println(quote.getQuote());
	}

	public void showCategoies(Categories categories) {
		System.out.println("\nChoose category: ");
		System.out.println(Arrays.toString(categories.getStringCategories()));
		showExit();
	}

	public void showCategory(Category category) {
		System.out.println("You choosed: " + category.getName());
	}
	
	public void showProjects(ArrayList<Project> projects) {
		
        for (Project project : projects) {
        	showProject(project);  
        	showLine();
        }
        System.out.println("\nChoose project: ");
        for (int i = 0; i < projects.size(); i++) {
        	System.out.print(String.valueOf(i+1) + " - " + projects.get(i).getName() + "; ");
        }
        showExit();
        System.out.println();
	}
	
	private void showLine() {
		System.out.println("--------------------------------------");
	}

	private void showProject(Project project) {
		System.out.println(project.getName());
        System.out.println(project.getDescription()); 
        System.out.println("Already collected " + project.getCollected() + " UAH for " + project.getDays() + " days"); 
        System.out.println("Need collect " + project.getAmount() + " UAH");	
	}

	private void showExit() {
		System.out.println("[0 - back]");
	}
	
	public void showFullProject(Project project) {
		showLine();
		showProject(project);
		Details details = project.getDetails();
		FAQ faq = details.getFAQ();
		System.out.println("History: " + details.getHistory());
		System.out.println("Video link: " + details.getVideo());
		System.out.println("\nFrequently Asked Questions: ");
		System.out.println(faq.getQuestion());
		System.out.println("\n" + faq.getAnswer());
		showLine();
		showExit();
	}
	
	
}
