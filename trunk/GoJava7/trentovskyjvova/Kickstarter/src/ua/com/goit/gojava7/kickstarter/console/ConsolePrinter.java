package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {

	public void print(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}
	
	public void print(List<Category> categories) {
		System.out.println("All categories:");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			System.out.println((i + 1) + " : " + category.getName());
		}
	}
	
	public void printProjects(List<Project> projects) {
		String format = "%-3s|%-20s|%10s|%10s|%10s%n";
		System.out.printf(format, "", "name", "funded", "days to go", "pledged");
		for (int i = 0; i < projects.size(); i++) {
			Project progect = projects.get(i);
			System.out.printf(format, progect.getProject(i + 1));
		}
	}
	
	public void print(String string) {
		System.out.println(string);
	}
}
