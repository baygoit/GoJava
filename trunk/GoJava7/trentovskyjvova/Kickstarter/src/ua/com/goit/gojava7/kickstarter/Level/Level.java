package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuestionStorage;

public interface Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject);

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory);

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject);

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner, QuestionStorage questionStorage,
			PaymentStorage paymentStorage);

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject);

}
