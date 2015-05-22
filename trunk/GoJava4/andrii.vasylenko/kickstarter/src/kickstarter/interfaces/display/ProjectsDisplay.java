package kickstarter.interfaces.display;

import kickstarter.engine.Project;

public class ProjectsDisplay extends AbstractDisplay<Project> {
	@Override
	public String getView(Project project) {
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
