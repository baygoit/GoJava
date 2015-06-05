package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.engine.Project;

public class AskQuestionModel implements Model {

	private ProjectsDAO projects;
	private int projectId;
	private int categoryId;
	private List<Object> parameters;

	public AskQuestionModel(ProjectsDAO projects, List<Object> parameters) {
		this.projects = projects;
		this.parameters = new ArrayList<Object>(parameters);
		Project project = (Project) parameters.get(0);
		this.projectId = project.getId();
		this.categoryId = project.getCategoryId();
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		return new ArrayList<>();
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws CannotAddDataException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 1) {
			projects.addQuestion(projectId, categoryId, input);
		}

		return result;
	}
}
