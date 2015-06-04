package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;

public class ProjectsModel implements Model {
	private ProjectsDAO projects;
	private int categoryId;
	private List<Object> parameters;

	public ProjectsModel(ProjectsDAO projects, List<Object> parameters) {
		this.projects = projects;
		this.parameters = new ArrayList<Object>(parameters);
		this.categoryId = ((Category) parameters.get(0)).getId();
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		for (Project project : projects.getProjects(categoryId)) {
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
		List<Object> result = new ArrayList<>(parameters);

		if (item == 0) {
			result.remove(0);
		} else {
			int id = item;
			Project project = projects.getProject(id, categoryId);
			result.add(0, project);
		}

		return result;
	}

	private String getDescription(Project project) {
		StringBuilder result = new StringBuilder();

		int item = project.getId();
		result.append(item);
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
