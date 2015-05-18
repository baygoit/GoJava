package kickstarter.interfaces.pages;

import kickstarter.engine.Project;

public class ShowProjectPage implements ChoicePage {

	private Project project;
	private Project chosenItem;

	public ShowProjectPage(Project project) {
		this.project = project;
	}

	@Override
	public String getHead() {
		return "--------------------" + "\r\n" + "Project:";
	}

	@Override
	public String getBody() {
		StringBuilder result = new StringBuilder();

		result.append(getDescription(project));

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
	}

	@Override
	public Project getChosenItem() {
		return chosenItem;
	}

	private String getDescription(Project project) {
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
