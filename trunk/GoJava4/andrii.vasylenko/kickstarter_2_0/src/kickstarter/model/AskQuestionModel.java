package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.QuestionsDAO;
import kickstarter.model.engine.Project;

public class AskQuestionModel implements Model {

	private QuestionsDAO dao;
	private int projectId;
	private List<Object> parameters;

	public AskQuestionModel(QuestionsDAO dao, List<Object> parameters) {
		this.dao = dao;
		this.parameters = new ArrayList<Object>(parameters);
		Project project = (Project) parameters.get(0);
		this.projectId = project.getId();
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
			dao.addQuestion(projectId, input);
		}

		return result;
	}
}
