package ua.com.goit.gojava7.kickstarter.console;

import java.util.Map;

import ua.com.goit.gojava7.kickstarter.memoryStorages.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String N = "\n";

	public void println(String string) {
		System.out.println(string);
	}

	public void println(Quote quote) {
		System.out.println(quote.getText() + N + quote.getAuthor());
	}

	public void println(Category category) {
		System.out.println("=======\n" + category.getCategoryName() + "\n=======");
	}

	public void println(CategoryStorage categoryStorage) {
		for (int i = 0; i < categoryStorage.getAllCategories().size(); i++) {
			System.out.println((i + 1) + " : " + categoryStorage.getCategory(i + 1).getCategoryName());
		}
	}

	public void println(CategoryStorage categoryStorage, int numberOfCategory) {
		Category projects = categoryStorage.getCategory(numberOfCategory);
		for (int i = 0; i < projects.getAllProjectsInCategory().size(); i++) {
			Project currentProject = projects.getAllProjectsInCategory().get(i);

			System.out.println("========================" + N + (i + 1) + " : " + currentProject.getProjectName() + N
					+ currentProject.getProjectShortDescription() + N + currentProject.getProjectCostNeed() + N
					+ currentProject.getProjectCostCollected() + N + currentProject.getProjectDaysLeft() + N
					+ "========================");
		}
	}

	public void println(Project project) {
		System.out.println(project.getProjectDescription() + N + project.getProjectCostNeed() + N
				+ project.getProjectCostCollected() + N + project.getProjectDaysLeft() + N + project.getVideoUrl());
		for (Map.Entry<String, String> entry : project.getQuestionsAndAnswer().entrySet()) {
			System.out.println(entry.getKey() + N + entry.getValue());
		}
		for (String question : project.getQuestionList()) {
			System.out.println(question);
		}

	}
}
