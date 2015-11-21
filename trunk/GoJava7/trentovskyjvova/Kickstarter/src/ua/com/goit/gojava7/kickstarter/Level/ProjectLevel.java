package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuestionStorage;

public class ProjectLevel implements Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("You selected '")
				.append(selectedProject.getName()).append("' project")
				.append("\n");
		stringBuilder.append(selectedProject.getAllDetails()).append("\n");
		stringBuilder.append("1 : to invest in the project").append("\n");
		stringBuilder.append("2 : to ask a question").append("\n");
		stringBuilder.append("0 : to project list");
		return stringBuilder.toString();
	}

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory) {
		return selectedCategory;
	}

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {
		StringBuilder stringBuilder = new StringBuilder();

		if (userChoise < 0 || userChoise > 2) { 
			stringBuilder.append("Please, enter the correct number");
		}
		return stringBuilder.toString();
	}

	@Override
	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner, QuestionStorage questionStorage,
			PaymentStorage paymentStorage) {

		return "";
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {
		if (selectedProject == null) {
			selectedProject = selectedCategory.getProject(userChoise);
		}
		return selectedProject;
	}

}
