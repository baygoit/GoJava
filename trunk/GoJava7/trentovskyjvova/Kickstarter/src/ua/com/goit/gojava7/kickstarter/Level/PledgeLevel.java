package ua.com.goit.gojava7.kickstarter.Level;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class PledgeLevel implements Level {

	@Override
	public String generateAnswer(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {

		return "";
	}

	@Override
	public Category findSelectedCategory(List<Category> categories,
			int userChoise, Category selectedCategory) {

		return selectedCategory;
	}

	@Override
	public String validateUserChoise(List<Category> categories, int userChoise,
			Category selectedCategory, Project selectedProject) {

		return "";
	}

	@Override
	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {
		ConsolePrinter consolePrinter = new ConsolePrinter();

		int donate = 0;
		String mistakeText = "";

		if (userChoise == project.rewardsSize() + 1) {
			consolePrinter.print("Enter amount to donate");
			donate = consoleScanner.scan();
		} else if (userChoise > 0) {
			mistakeText = validateUserChoise(new ArrayList<Category>(),
					userChoise, new Category("", 0), project);
			if (mistakeText.equals("")) {
				donate = project.getReward(userChoise - 1).getPledge();
			} else {
				consolePrinter.print(mistakeText);
			}
		}

		if (donate == 0) {
			return "0 : back to rewards";
		}
		consolePrinter.print("Enter your name");
		String name = consoleScanner.scanLine();
		consolePrinter.print("Enter card number");
		String card = consoleScanner.scanLine();

		project.setPledged(project.getPledged() + donate); // TODO create class
															// Pledge

		return "Thank you!\n0 : back to rewards";
	}

	@Override
	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return selectedProject;
	}

}
