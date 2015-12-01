package ua.com.goit.gojava7.kickstarter.Level;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface Level {
	
	public String generateAnswer(int userChoise,
			Category selectedCategory, Project selectedProject);

	public Category findSelectedCategory(int userChoise,
			Category selectedCategory);

	public String validateUserChoise(int userChoise,	Category selectedCategory, Project selectedProject);

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner);

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject);

}
