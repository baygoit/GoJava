package ua.com.goit.gojava7.kickstarter.Level;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class PaymentLevel implements Level {

	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {

		return "";
	}

	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory) {
		return selectedCategory;
	}

	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory) {

		return "";
	}

	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {
		ConsolePrinter consolePrinter = new ConsolePrinter();

		if (userChoise == 1) {
			consolePrinter.print("Enter your name");
			String name = consoleScanner.scanLine();
			consolePrinter.print("Enter card number");
			String card = consoleScanner.scanLine();
			consolePrinter.print("Enter amount to donate");
			int donate = consoleScanner.scan();

			project.setPledged(project.getPledged() + donate);

			return "Thank you!\n0 : back to project";
		} else if (userChoise == 2) {
			consolePrinter.print("Enter your question");
			String question = consoleScanner.scanLine();
			
			project.addQuestion(question);
			
			return "Thank for your question!\n0 : back to project";
		} else {
			return "";
		}
	}

	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return selectedProject;
	}

}
