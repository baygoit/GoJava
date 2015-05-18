package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.iStorage;

public class ProjectsPage extends Page {
	
	public ProjectsPage(ProjectRepository projects, Model model) {
		this.projects = projects;
		navigator = model;
	}

	public void setParameterForPrint(int parameterForPage) {
		this.parameterForPage = parameterForPage;
	}

	public void viewWorkedStatus(int status) {
	}
	public iStorage<Project> sortProjectsByCategoryID(int categoryID) {

		iStorage<Project> sortedProjects = new EntityStorage<Project>();
		int length = projects.getProjectsLength();
		for (int index = 0; index < length; index++) {
			Project project = projects.getProject(index);
			if (project.categoryID == categoryID) {
				sortedProjects.add(project);
			}
		}
		return sortedProjects;
	}
	
	public String printProjectsInfo(int categoryID) {
		String result = "";
		iStorage<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.length();
		options = new String[length];
		optionsInt = new int[length];
		for (int index = 0; index < length; index++) {
			Project project = sortedToSelect.getEntity(index);
			options[index] = Integer.toString(project.ID);
			optionsInt[index] = project.ID;
			result += ("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
		return result;
	}
	public String getHeader() {

		String header = "";
		header += "\n________________________";
		header += "\n|     Projects         |";
		header += "\n|______________________|";
		header += "\n";
		header += printProjectsInfo(parameterForPage);
		header += "\n------------------------";
		header += "\nSelect project by ID:<ID>";
		header += "\nOptions:  <p> - previous page";
		return header;
	}

	public void execute(String message) {
		navigator.saveCategory(parameterForPage);
		if (message.equals("p")) {
			navigator.pageWillBe(CATEGORIES);
			return;
		}

		if (options != null) {
			for (int index = 0; index < options.length; index++) {
				if (message.equals(options[index])) {
					navigator.pageWillBe(DETAILED_PROJECT);
					navigator.setOption(optionsInt[index], options[index]);
					return;
				}
			}
		}
		navigator.savePageBeforeError(PROJECTS);
		navigator.pageWillBe(ERROR_PAGE);
	}
}
