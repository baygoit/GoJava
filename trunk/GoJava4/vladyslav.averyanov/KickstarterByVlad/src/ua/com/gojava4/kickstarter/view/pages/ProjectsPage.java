package ua.com.gojava4.kickstarter.view.pages;

import java.util.List;

import ua.com.gojava4.kickstarter.control.DataIOTypeStorage;
import ua.com.gojava4.kickstarter.entities.Project;

public class ProjectsPage implements Page {

	private DataIOTypeStorage dataIOTypeStorage;
	private int categoryId;
	private List<Project> projectsOfTheCategory;

	public ProjectsPage(DataIOTypeStorage dataIOTypeStorage, int categoryId) {
		this.dataIOTypeStorage = dataIOTypeStorage;
		this.categoryId = categoryId;
		this.projectsOfTheCategory = dataIOTypeStorage.getDao().getAllProjectsOfCategory(categoryId);
	}

	@Override
	public void showPage() {
		showProjectsOfTheCategory();
	}

	private void showProjectsOfTheCategory() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n   Projects of Category ");
		sb.append(dataIOTypeStorage.getDao().getCategoryById(categoryId).getName());
		sb.append("\n");
		for (Project project : projectsOfTheCategory) {
			if (project.getCategoryId() == categoryId){
				sb.append("<");
				sb.append(project.getId());
				sb.append("> ");
				sb.append(project.getName());
				sb.append("\n");
			}
		}
		dataIOTypeStorage.getWriter().println(sb.toString());
	}

	@Override
	public Page getNextPage() {
		String userInput = dataIOTypeStorage.getReader().readUserInput();
		try {
			int projectId = Integer.parseInt(userInput);
			for (Project project : projectsOfTheCategory) {
				if (project.getId() == projectId) {
					return new DetailedProjectPage(dataIOTypeStorage, project);
				}
			}
		} catch (NumberFormatException e) {
			if (userInput.toLowerCase().equals("q")) {
				System.exit(0);
			} else if (userInput.toLowerCase().equals("prev")){
				return new CategoriesPage(dataIOTypeStorage);
			}
		}
		showErrorDescription();
		return this;
	}

	private void showErrorDescription() {
		dataIOTypeStorage.getWriter().println("There is no such project!\n");
	}

}
