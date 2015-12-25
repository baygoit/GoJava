package ua.com.goit.gojava7.kickstarter.model;

public class Question {
	private int idQuestion;
	private int idParentProject;
	private String questionText;

	public Question() {}

	public String getQuestionText() {
		return questionText;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public int getIdParentProject() {
		return idParentProject;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	public void setIdParentProject(int idParentProject) {
		this.idParentProject = idParentProject;
	}
	@Override
	public String toString() {
		return "Project ID: " + idParentProject + "; "
				+ "Question: " + questionText + "; ";
	}
}
