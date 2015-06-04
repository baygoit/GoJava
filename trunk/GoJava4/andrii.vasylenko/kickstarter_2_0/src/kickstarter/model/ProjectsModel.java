package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;

public class ProjectsModel implements Model {
	private ProjectsDAO projects;
	private Category category;
	private List<Object> parameters;

	public ProjectsModel(ProjectsDAO projects, List<Object> parameters) {
		this.projects = projects;
		this.parameters = new ArrayList<Object>(parameters);
		this.category = (Category) parameters.get(0);
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		List<Project> projectsList = projects.getProjects(category.getId());
		for (int i = 0; i < projectsList.size(); i++) {
			Project project = projectsList.get(i);
			result.add(getDescription(project));
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item) throws CannotGetDataException {
		if (item == 0) {
			parameters.remove(0);
		} else {
			// parameters.add(0, storage.getProject(item - 1, category));
			parameters.add(0, projects.getProject(item, category.getId()));
		}

		return parameters;
	}

	private String getDescription(Project project) {
		StringBuilder result = new StringBuilder();

		// int numberInMenu = project.getId() + 1;
		int numberInMenu = project.getId();
		result.append(numberInMenu);
		result.append(" - ");

		result.append(project.getName());

		result.append(", description=");
		result.append(project.getDescription());

		result.append(", totalAmount=");
		result.append(project.getTotalAmount());

		result.append(", collectAmount=");
		result.append(project.getCollectAmount());

		result.append(", daysLeft=");
		result.append(project.getDaysLeft());

		return result.toString();
	}
}
