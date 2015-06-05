package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.engine.Project;

public class ProjectModel implements Model {
	private ProjectsDAO projects;
	private int projectId;
	private int categoryId;
	private List<Object> parameters;

	public ProjectModel(ProjectsDAO projects, List<Object> parameters) {
		this.projects = projects;
		this.parameters = new ArrayList<Object>(parameters);
		Project project = (Project) parameters.get(0);
		this.projectId = project.getId();
		this.categoryId = project.getCategoryId();
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		Project project = projects.getProject(projectId, categoryId);

		addData(result, project);

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws CannotGetDataException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 0) {
			result.remove(0);
		} else if (item == 1) {

		} else {
			throw new CannotGetDataException("Illegal parameters");
		}

		return result;
	}

	private void addData(List<String> result, Project project) {
		result.add(String.format("name=%s", project.getName()));
		result.add(String.format("description=%s", project.getDescription()));
		result.add(String.format("totalAmount=%s", project.getTotalAmount()));
		result.add(String.format("collectAmount=%s", project.getCollectAmount()));
		result.add(String.format("daysLeft=%s", project.getDaysLeft()));
		result.add(String.format("history=%s", project.getHistory()));
		result.add(String.format("link=%s", project.getLink()));
		for (String question : project.getQuestionsAndAnswers()) {
			result.add(String.format("  question=%s", question));
		}
	}
}
