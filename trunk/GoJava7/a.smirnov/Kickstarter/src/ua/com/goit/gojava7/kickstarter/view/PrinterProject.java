package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
// OLEG unused import
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class PrinterProject {
	private List<Project> listOfProjects = null;
	private static final String SEPARATOR = "=========================";

	// OLEG wow, not DAO here. Thanks God :)
	// OLEG what about this "\n" everywhere? 
	public void printProjectsInfo(Project project) {
		StringBuilder result = new StringBuilder();
		// OLEG unreadable
		result.append("Title: ").append(project.getTitle()).append("\n").append("Brief description: ")
				.append(project.getBriefDescription()).append("\n").append("Project description: ")
				.append(project.getFullDescription()).append("\n").append("Days to go: ").append(project.getDaysLeft())
				.append("\n").append("Required amount of $: ").append(project.getRequiredAmountOfMoney()).append("\n")
				.append("Collected amount of money:").append(project.getCurrentAmoutOfMoney()).append("\n")
				.append("List of categories: ").append(project.getCategories());
		// OLEG no toString please
		System.out.println(result.toString());
	}

	// OLEG well, if we gave a category printer, why we print categories here?
	// OLEG why we pass DAO? why not list of projects to print?
	public void printProjectsFromCategory(ProjectDAO allProjects, String categoryName) {
		listOfProjects = allProjects.getDataSource();
		for (Project project : listOfProjects) {
			List<String> listOfProjectCategories = project.getCategories();
			for (String prjectCategory : listOfProjectCategories) {
				if (prjectCategory.equals(categoryName)) {
					System.out.println(SEPARATOR);
					printProjectsInfo(project);
				}
			}
		}
	}

}
