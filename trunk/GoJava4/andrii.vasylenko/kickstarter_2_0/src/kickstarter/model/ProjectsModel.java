package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.storage.Storage;

public class ProjectsModel implements Model {
	private Storage storage;
	private Category category;
	private List<Object> parameters;

	public ProjectsModel(Storage storage, List<Object> parameters) {
		this.storage = storage;
		this.parameters = new ArrayList<Object>(parameters);
		this.category = (Category) parameters.get(0);
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		List<Project> projects = storage.getProjects(category);
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
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
			//parameters.add(0, storage.getProject(item - 1, category));
			parameters.add(0, storage.getProject(item, category));
		}

		return parameters;
	}

	private String getDescription(Project project) {
		StringBuilder result = new StringBuilder();

		//int numberInMenu = project.getId() + 1;
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
