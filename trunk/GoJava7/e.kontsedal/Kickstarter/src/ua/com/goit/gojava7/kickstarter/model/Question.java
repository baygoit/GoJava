package ua.com.goit.gojava7.kickstarter.model;

public class Question {
	private String questionText;
	private int idQuestion;
	private int idParentProject;

	public Question() {
	}

	public String getQuestion() {
		return questionText;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public int getIdParentProject() {
		return idParentProject;
	}

	public void setQuestion(String question) {
		this.questionText = question;
	}

	public void setIdParentProject(int idParentProject) {
		this.idParentProject = idParentProject;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
}
