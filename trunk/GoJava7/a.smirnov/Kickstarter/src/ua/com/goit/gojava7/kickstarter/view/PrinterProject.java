package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class PrinterProject {
	private List<Project> listOfProjects = null;
	
	
	public void printProjectsFromCategory(String s) {
		ProjectDAO storageOfProjects = new ProjectDAO();

		listOfProjects = storageOfProjects.getDataSource();
		int amountOfProjects = listOfProjects.size();
		
		for (int index = 0; index < amountOfProjects; index++) {
			
			List<String> projectCategories = listOfProjects.get(index).getCategories();
			
			for (String category : projectCategories) {
				if (category.equals(s)) {
					printProjectsInfo(listOfProjects.get(index));
				}
			}
		}
	}
	
	public void printProjectsInfo(Project project) {

		StringBuilder result = new StringBuilder();
		
		result.append("Title: ").append(project.getTitle()).append("\n").
			append("Brief description: ").append(project.getBriefDescription()).append("\n").
			append("Project description: ").append(project.getFullDescription()).append("\n").
			append("Days to go: ").append(project.getDaysLeft()).append("\n").
			append("Required amount of $: ").append(project.getRequiredAmountOfMoney()).append("\n").
			append("Collected amount of money:").append(project.getCurrentAmoutOfMoney());
		System.out.println(result.toString());
	}
}
