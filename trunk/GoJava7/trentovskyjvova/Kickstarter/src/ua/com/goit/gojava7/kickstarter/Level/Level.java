package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface Level {

	public String generateAnswer(List<Category> categories, int userChoise, Category selectedCategory);

	public Category findSelectedCategory(List<Category> categories, int userChoise, Category selectedCategory);

	public String validateUserChoise(List<Category> categories, int userChoise, Category selectedCategory);

}
