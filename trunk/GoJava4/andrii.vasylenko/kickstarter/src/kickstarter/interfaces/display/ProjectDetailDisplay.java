package kickstarter.interfaces.display;

import kickstarter.engine.Project;

public class ProjectDetailDisplay implements Display<Project> {
	@Override
	public String getDescription(Project project) {
		if (project == null) {
			return "";
		}
		
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
		result.append("\r\n");

		return result.toString();
	}
}
