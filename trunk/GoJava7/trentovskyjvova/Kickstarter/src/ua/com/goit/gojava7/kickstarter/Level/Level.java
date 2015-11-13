package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface Level {

	public StringBuilder generateAnswer(List<Category> categories, int userChoise, Category selectedCategory);

	public Category findSelectedCategory(List<Category> categories, int userChoise, Category selectedCategory);

	public StringBuilder validateUserChoise(List<Category> categories, int userChoise, Category selectedCategory);

}
