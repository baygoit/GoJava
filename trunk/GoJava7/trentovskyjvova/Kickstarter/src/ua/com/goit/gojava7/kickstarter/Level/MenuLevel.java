package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class MenuLevel implements Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("All categories:").append("\n");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			stringBuilder.append((i + 1)).append(" : ")
					.append(category.getName()).append("\n");
		}
		stringBuilder.append(0).append(" : Exit from application").append("\n");
		stringBuilder.append("Select a category");

		return stringBuilder.toString();
	}

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory) {
		return null;
	}

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise < 0 || userChoise > categories.size()) {
			stringBuilder.append("Please, enter the number between 0 and ")
					.append(categories.size());
		}
		return stringBuilder.toString();
	}

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {

		return "";
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {
		// TODO Auto-generated method stub
		return null;
	}
}
