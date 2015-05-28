package kickstarter.pages.viewContent;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Project;
import kickstarter.mvc.viewState.ViewValues;
import kickstarter.repository.facade.RepositoryException;

public class Projects extends PageView {
	Project project;

	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws RepositoryException {

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

	public String printProjectsInfo(int categoryID) throws RepositoryException {
		StringBuilder result = new StringBuilder();
		List<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.size();
		strValues = new String[length];
		intValues = new int[length];
		for (int index = 0; index < length; index++) {
			project = sortedToSelect.get(index);

			strValues[index] = Integer.toString(project.ID);
			intValues[index] = project.ID;

			result.append("\nID:<");
			result.append(project.ID);
			result.append("> name:<");
			result.append(project.name);
			result.append(">\n short desc.:<");
			result.append(project.shortDescription);
			result.append(">\n goal:<");
			result.append(project.goal);
			result.append(">\n pledged:<");
			result.append(project.pledged);
			result.append(">\n days to go:<");
			result.append(project.daysToGo);
			result.append(">");
			result.append("\n================================");
		}
		ViewValues ViewValues = iview.getViewValues();
		ViewValues.intProjects = intValues;
		ViewValues.strProjects = strValues;
		return result.toString();
	}

	public String getHeader() throws RepositoryException {

		StringBuilder header = new StringBuilder();
		header.append("\n________________________");
		header.append("\n|     Projects         |");
		header.append("\n|______________________|");
		header.append("\n");
		header.append(printProjectsInfo(imodel.getModelValues().intSelectedCategory));
		header.append("\n------------------------");
		header.append("\nSelect project by ID:<ID>");
		header.append("\nOptions:  <p> - previous page");
		return header.toString();
	}
}
