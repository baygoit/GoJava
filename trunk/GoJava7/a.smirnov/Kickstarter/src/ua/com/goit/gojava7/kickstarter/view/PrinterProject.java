package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;

// OLEG unused import
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class PrinterProject {
	private static final String SEPARATOR = "=========================";

	public String printProjectInfo(Project project) {
		StringBuilder result = new StringBuilder();
		result.append("Title: ").append(project.getTitle()).append("\n").
			append("Brief description: ").append(project.getBriefDescription()).append("\n").
			append("Project description: ").append(project.getFullDescription()).append("\n").
			append("Days to go: ").append(project.getDaysLeft()).append("\n").
			append("Required amount of $: ").append(project.getRequiredAmountOfMoney()).append("\n").
			append("Collected amount of $:").append(project.getCurrentAmoutOfMoney()).append("\n").
			append("List of categories: ").append(project.getCategories());
		
		return result.toString();
	}

	
	// OLEG wow, not DAO here. Thanks God :)
	// OLEG what about this "\n" everywhere? 
	

	// OLEG well, if we gave a category printer, why we print categories here?
	// OLEG why we pass DAO? why not list of projects to print?
	public String printProjectsFromCategory(ProjectDAO allProjects, String categoryName) {
		List<Project> listOfProjects = allProjects.getDataSource();
		StringBuilder result = new StringBuilder();
		for (Project project : listOfProjects) {
			List<String> listOfProjectCategories = project.getCategories();
			for (String prjectCategory : listOfProjectCategories) {
				if (prjectCategory.equals(categoryName)) {
					result.append(SEPARATOR).
						append("\n").
						append(printProjectInfo(project)).
						append("\n");
				}
			}
		}
		if (result.toString().isEmpty()) {
			return "There is no any project in this category";
		} else {
			return result.toString();
		}
	}

}
