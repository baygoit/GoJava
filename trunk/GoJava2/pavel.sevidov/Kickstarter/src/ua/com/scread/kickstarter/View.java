package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.Arrays;

public class View {

	public View() {
		
	}
	
	public void greed() {
		QuoteGenerator quote = new QuoteGenerator();
		System.out.println(quote.getQuote());
	}

	public void showCategoies(Categories categories) {
		System.out.println("\nChoose category: ");
		System.out.println(Arrays.toString(categories.getStringCategories()));
	}

	public void showCategory(Category category) {
		System.out.println("You choosed: " + category.getName());
	}
	
	public void showProjects(ArrayList<Project> projects) {
		System.out.println("--------------------------------------");
        for (Project project : projects) {
                System.out.println(project.getName());
                System.out.println(project.getDescription()); 
                System.out.println("Already collected " + project.getCollected() + " UAH for " + project.getDays() + " days"); 
                System.out.println("Need collect " + project.getAmount() + " UAH");
                System.out.println("--------------------------------------");                           
        }
	}
	
}
