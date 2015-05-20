package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.iModel;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.iStorage;

public class Projects extends PageView {

	public Projects(ProjectRepository projects, iModel imodel) {
		this.projects = projects;
		this.imodel = imodel;
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
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {
			Project project = sortedToSelect.getEntity(index);
			strOptions[index] = Integer.toString(project.ID);
			intOptions[index] = project.ID;
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
		header += printProjectsInfo(intOption);
		header += "\n------------------------";
		header += "\nSelect project by ID:<ID>";
		header += "\nOptions:  <p> - previous page";
		return header;
	}

}
