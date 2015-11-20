package ua.com.goit.gojava7.kickstarter.domain;

public class Question {
	private final int id;
	private int projectId;
	private String questionText;

	public Question(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
