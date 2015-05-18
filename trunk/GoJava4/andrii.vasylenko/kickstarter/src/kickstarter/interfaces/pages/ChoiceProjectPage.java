package kickstarter.interfaces.pages;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.storages.ProjectsStorage;

public class ChoiceProjectPage implements ChoicePage {

	private ProjectsStorage projects;
	private ProjectsStorage localProjects;
	private Category category;
	private Project chosenItem;

	public ChoiceProjectPage(ProjectsStorage projects, Category category) {
		this.projects = projects;
		this.category = category;
		this.localProjects = getProjectsInCategory();
	}

	@Override
	public String getHead() {
		return "--------------------" + "\r\n" + "Choice Project:";
	}

	@Override
	public String getBody() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < localProjects.size(); i++) {
			result.append(getDescription(localProjects.get(i)));
		}

		result.append(Project.EXIT.getId());
		result.append(" - ");
		result.append(Project.EXIT.getName());
		result.append("\r\n");

		return result.toString();
	}

	@Override
	public void setChosenItem(int itemId) {
		if (itemId == Project.EXIT.getId()) {
			chosenItem = Project.EXIT;
			return;
		}

		chosenItem = localProjects.getById(itemId);
	}

	@Override
	public Project getChosenItem() {
		return chosenItem;
	}

	private ProjectsStorage getProjectsInCategory() {
		ProjectsStorage result = new ProjectsStorage();

		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getCategory() == category) {
				result.add(projects.get(i));
			}
		}

		return result;
	}

	private String getDescription(Project project) {
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
