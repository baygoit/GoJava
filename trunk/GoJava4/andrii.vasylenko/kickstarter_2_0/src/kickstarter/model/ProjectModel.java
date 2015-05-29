package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.model.engine.Project;

public class ProjectModel implements Model {
	private Project project;
	private List<Object> parameters;

	public ProjectModel(List<Object> parameters) {
		this.parameters = new ArrayList<Object>(parameters);
		this.project = (Project) parameters.get(0);
	}

	@Override
	public List<String> getData() {
		List<String> result = new ArrayList<>();

		result.add("name=" + project.getName());
		result.add("description=" + project.getDescription());
		result.add("totalAmount=" + project.getTotalAmount());
		result.add("collectAmount=" + project.getCollectAmount());
		result.add("daysLeft=" + project.getDaysLeft());
		result.add("history=" + project.getHistory());
		result.add("link=" + project.getLink());
		result.add("questionsAndAnswers=" + project.getQuestionsAndAnswers());

		return result;
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item) {
		if (item == 0) {
			parameters.remove(0);
		} else {
			throw new IllegalArgumentException();
		}

		return parameters;
	}
}
