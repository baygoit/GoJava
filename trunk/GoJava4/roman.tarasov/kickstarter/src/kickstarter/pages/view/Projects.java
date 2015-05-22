package kickstarter.pages.view;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.fasade.Repository;

public class Projects extends PageView {

	public Projects(Repository repository, iModel imodel) {
		this.repository=repository;
		this.imodel = imodel;
	}

	public List<Project> sortProjectsByCategoryID(int categoryID) {

		List<Project> sortedProjects = new ArrayList<Project>();
		int length = repository.getProjectsLength();
		for (int index = 0; index < length; index++) {
			Project project = repository.getProject(index);
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
			Project project = sortedToSelect.get(index);

			strOptions[index] = Integer.toString(project.ID);
			intOptions[index] = project.ID;

			result += ("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
		ViewOptions vo = imodel.getViewOptions();
		vo.intProjects = intOptions;
		vo.strProjects = strOptions;

		return result;
	}

	public String getHeader() {

		String header = "";
		header += "\n________________________";
		header += "\n|     Projects         |";
		header += "\n|______________________|";
		header += "\n";
		ModelOptions mo = imodel.getModelOptions();
		int categogyID = mo.intSelectedCategory;
		header += printProjectsInfo(categogyID);
		header += "\n------------------------";
		header += "\nSelect project by ID:<ID>";
		header += "\nOptions:  <p> - previous page";
		return header;
	}

}
