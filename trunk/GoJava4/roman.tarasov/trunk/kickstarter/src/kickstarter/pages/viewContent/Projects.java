package kickstarter.pages.viewContent;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.facade.Repository;

public class Projects extends PageView {

	public Projects(Repository repository, iModel imodel) {
		this.repository = repository;
		this.imodel = imodel;
	}

	public List<Project> sortProjectsByCategoryID(int categoryID) {

		List<Project> sortedProjects = new ArrayList<Project>();
		int length = repository.getProjectsLength();
		for (int index = 0; index < length; index++) {
			project = repository.getProject(index);
			if (project.categoryID == categoryID) {
				sortedProjects.add(project);
			}
		}
		return sortedProjects;
	}

	public String printProjectsInfo(int categoryID) {
		String result = "";
		List<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.size();
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {
			project = sortedToSelect.get(index);

			strOptions[index] = Integer.toString(project.ID);
			intOptions[index] = project.ID;

			result += ("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
		ViewOptions viewOptions = imodel.getViewOptions();
		viewOptions.intProjects = intOptions;
		viewOptions.strProjects = strOptions;
		return result;
	}

	public String getHeader() {

		StringBuilder header = new StringBuilder();
		header.append("\n________________________");
		header.append("\n|     Projects         |");
		header.append("\n|______________________|");
		header.append("\n");
		header.append(printProjectsInfo(imodel.getModelOptions().intSelectedCategory));
		header.append("\n------------------------");
		header.append("\nSelect project by ID:<ID>");
		header.append("\nOptions:  <p> - previous page");
		return header.toString();
	}

}
