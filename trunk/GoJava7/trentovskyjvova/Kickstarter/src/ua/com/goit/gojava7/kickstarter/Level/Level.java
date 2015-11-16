package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject);

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory);

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory);

	public String fillOutForm(Project project, int userChoise, ConsoleScanner consoleScanner);

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject);

}
