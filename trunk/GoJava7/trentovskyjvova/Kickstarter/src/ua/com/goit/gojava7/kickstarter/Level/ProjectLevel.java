package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectLevel implements Level {

	public StringBuilder generateAnswer(List<Category> categories, int userChoise, Category selectedCategory) {
		StringBuilder stringBuilder = new StringBuilder();
		Project project = selectedCategory.getProject(userChoise);

		stringBuilder.append("You selected '").append(project.getName()).append("' project").append("\n");
		stringBuilder.append(project.getAllDetails()).append("\n");
		stringBuilder.append(0).append(" : to project list");
		return stringBuilder;
	}

	public Category findSelectedCategory(List<Category> categories, int userChoise, Category selectedCategory) {
		return selectedCategory;
	}

	public StringBuilder validateUserChoise(List<Category> categories, int userChoise, Category selectedCategory) {
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise != 0) {
			stringBuilder.append("Please, enter the correct number");
		}
		return stringBuilder;
	}

}
