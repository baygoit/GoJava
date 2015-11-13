package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class CategoryPrinter {
	public void printCategories(List<Category> categories) {
		for (int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}
	}

	public void printProjects(List<Project> projects) {
		for (int i = 0; i < projects.size(); i++) {
			System.out.println("\n" + (i + 1) + ":");
			ProjectPrinter projectPrinter = new ProjectPrinter(projects.get(i));
			projectPrinter.printShort();
		}
	}
}
