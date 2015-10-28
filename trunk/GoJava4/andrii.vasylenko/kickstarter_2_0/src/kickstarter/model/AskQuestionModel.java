package kickstarter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.model.dao.DAO;
import kickstarter.model.engine.Project;

public class AskQuestionModel implements Model {

	private DAO dao;
	private int projectId;
	private List<Object> parameters;

	@Override
	public void init(DAO dao, List<Object> parameters) {
		this.dao = dao;
		this.parameters = new ArrayList<Object>(parameters);
		Project project = (Project) parameters.get(0);
		this.projectId = project.getId();
	}

	@Override
	public List<String> getData() {
		return new ArrayList<>();
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws SQLException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 1) {
			dao.addQuestion(projectId, input);
		}

		return result;
	}
}
