package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class MenuLevel implements Level {

	public StringBuilder generateAnswer(List<Category> categories, int userChoise, Category selectedCategory) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("All categories:").append("\n");
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			stringBuilder.append((i + 1)).append(" : ").append(category.getName()).append("\n");
		}
		stringBuilder.append(0).append(" : Exit from application").append("\n");
		stringBuilder.append("Select a category");

		return stringBuilder;
	}

	public Category findSelectedCategory(List<Category> categories, int userChoise, Category selectedCategory) {
		return null;
	}

	public StringBuilder validateUserChoise(List<Category> categories, int userChoise, Category selectedCategory) {
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise < 0 || userChoise > categories.size()) {
			stringBuilder.append("Please, enter the number between 0 and ").append(categories.size());
		}
		return stringBuilder;
	}
}
