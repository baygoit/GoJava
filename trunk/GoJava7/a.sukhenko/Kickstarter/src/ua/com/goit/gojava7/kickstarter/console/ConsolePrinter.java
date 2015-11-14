package ua.com.goit.gojava7.kickstarter.console;

import java.util.ArrayList;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class ConsolePrinter {
	private final String deflector = "===========================";

	public void println(String s) {
		System.out.println(s);
	}

	public void printDeflector() {
		System.out.println(deflector);
	}

	public void println(Quote quote) {
		System.out.println("\"" + quote.getQuoteName() + "\"\n" + quote.getAuthor());

	}

	public void printCategory(Category b) {
		System.out.println(b.getCategoryId() + "# " + b.getCategoryName());

	}

	public void print(Map<Integer, Category> categories) {
		System.out.println("Categories: ");
		categories.forEach((id, cat) -> {
			System.out.println(id + "# " + cat.getCategoryName());
		});
	}

	public void showProjectList(Category cat, ProjectManager projectManager) {
		ArrayList<Project> projects = projectManager.getProjectsByCategory(cat);
		for (int i = 0; i < projects.size(); i++) {
			println(i + 1 + "# " + projects.get(i).getProjectName());
		}

	}

	public void printFullProjectInfo(Project project) {
		printDeflector();
		println("Project: " + project.getProjectName() + "   |  Category: "
				+ project.getProjectCategory().getCategoryName());
		println(project.getProjectEndTime());
		println("[ " + project.getProjectDescription() + " ]");
		println("History: " + getBlankStringIfNull(project.getProjectHistory()));
		println("Demo: " + getBlankStringIfNull(project.getDemoLink()));
		println("Funded: " + project.getFundedPercentage() + " Backers: " + project.getBackers().size()
				+ " | Pledged: $" + project.getMoneyPledged());
		printQuestionsAndAnswers(project.getQuestionsAndAnswers());

	}

	public void printQuestionsAndAnswers(Map<String, String> qa) {
		println("Questions and Answers:");
		qa.forEach((q, a) -> {
			println("Q: " + q);
			println("A: " + a);
			printDeflector();
		});
	}

	public String getBlankStringIfNull(String s) {
		String blank = " - ";
		if (s == null)
			return blank;
		else {
			return s;
		}
	}

}
