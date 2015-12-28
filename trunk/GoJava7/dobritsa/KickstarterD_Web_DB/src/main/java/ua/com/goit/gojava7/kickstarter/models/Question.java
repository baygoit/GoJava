package ua.com.goit.gojava7.kickstarter.models;

import java.util.Date;

public class Question {

	private Long questionId;
	private String time = "";
	private String question = "";
	private String answer = "";	
	private Project project = new Project();

	public Question() {
		this.time = new Date().toString();
	}
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answear) {
		this.answer = answear;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getProjectId() {
		return project.getProjectId();
	}

	public void setProjectId(Long projectId) {
		project.setProjectId(projectId);
	}

	@Override
	public String toString() {
		return "questionId: " + questionId + "; time: " + time + "; question: " + question + "; answer: " + answer + "; projectId: " + getProjectId();
	}
}
