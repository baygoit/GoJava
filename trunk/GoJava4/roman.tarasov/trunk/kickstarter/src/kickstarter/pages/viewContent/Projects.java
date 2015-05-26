package kickstarter.pages.viewContent;

import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public class Projects extends PageView {

	public Projects(iRepository repository, iModel imodel) {
		this.repository = repository;
		this.imodel = imodel;
	}

	public List<Project> sortProjectsByCategoryID(int categoryID) throws RepositoryException  {

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

	public String printProjectsInfo(int categoryID) throws RepositoryException  {
		StringBuilder result = new StringBuilder();
		List<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.size();
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {
			project = sortedToSelect.get(index);

			strOptions[index] = Integer.toString(project.ID);
			intOptions[index] = project.ID;

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
		ViewOptions viewOptions = imodel.getViewOptions();
		viewOptions.intProjects = intOptions;
		viewOptions.strProjects = strOptions;
		return result.toString();
	}

	public String getHeader() throws RepositoryException  {

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
