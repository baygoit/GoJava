package kickstarter.interfaces.display;

import kickstarter.engine.Project;

public class ProjectDisplay implements Display<Project> {
	@Override
	public String getDescription(Project project) {
		if (project == null) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();

		result.append(project.getId());
		result.append(" - " + project.getName());
		result.append(", description=" + project.getDescription());
		result.append(", totalAmount=" + project.getTotalAmount());
		result.append(", collectAmount=" + project.getCollectAmount());
		result.append(", daysLeft=" + project.getDaysLeft());
		result.append("\r\n");

		return result.toString();
	}
}
