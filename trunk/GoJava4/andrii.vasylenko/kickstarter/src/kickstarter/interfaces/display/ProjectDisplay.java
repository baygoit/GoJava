package kickstarter.interfaces.display;

import kickstarter.engine.Project;

public class ProjectDisplay implements Display<Project> {

	@Override
	public String getDescription(Project project) {
		StringBuilder result = new StringBuilder();

		result.append(project.getId());
		result.append(" - " + project.getName());
		result.append(", description=" + project.getDescription());
		result.append(", totalAmount=" + project.getTotalAmount());
		result.append(", collectAmount=" + project.getCollectAmount());
		result.append(", daysLeft=" + project.getDaysLeft());

		return result.toString();
	}

	@Override
	public String getDetailedDescription(Project project) {
		StringBuilder result = new StringBuilder();

		result.append("name=");
		result.append(project.getName());
		result.append("\r\n description=");
		result.append(project.getDescription());
		result.append("\r\n totalAmount=");
		result.append(project.getTotalAmount());
		result.append("\r\n collectAmount=");
		result.append(project.getCollectAmount());
		result.append("\r\n daysLeft=");
		result.append(project.getDaysLeft());
		result.append("\r\n history=");
		result.append(project.getHistory());
		result.append("\r\n link=");
		result.append(project.getLink());
		result.append("\r\n questionsAndAnswers=");
		result.append(project.getQuestionsAndAnswers());

		return result.toString();
	}

}
