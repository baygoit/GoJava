package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class MenuLevel implements Level {
	private CategoryDao categoryDao;

	public MenuLevel(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public String generateAnswer(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("All categories:").append("\n");
		List<Category> categories = categoryDao.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			stringBuilder.append((i + 1)).append(" : ")
					.append(category.getName()).append("\n");
		}
		stringBuilder.append(0).append(" : Exit from application").append("\n");
		stringBuilder.append("Select a category");

		return stringBuilder.toString();
	}

	public Category findSelectedCategory(int userChoise,
			Category selectedCategory) {

		selectedCategory = categoryDao.getCategory(userChoise); 
		return selectedCategory;
	}

	public String validateUserChoise(int userChoise, Category selectedCategory,
			Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();
		
		int categoriesSize = categoryDao.size();
		if (userChoise < 0 || userChoise > categoriesSize) {
			stringBuilder.append("Please, enter the number between 0 and ")
					.append(categoriesSize);
		}
		return stringBuilder.toString();
	}

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {

		return "";
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return null;
	}

}
