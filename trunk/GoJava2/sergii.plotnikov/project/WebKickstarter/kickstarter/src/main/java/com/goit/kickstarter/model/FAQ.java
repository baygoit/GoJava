package com.goit.kickstarter.model;

public class FAQ {
	private String question;
	private String answer;
	private int projectId;

	public FAQ(String string, int id) {
		question = string;
		projectId=id;
	}
	
	public FAQ(String question, String answer, int id) {
		this.question = question;
		this.answer = answer;
		projectId=id;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getProjectId() {
		return projectId;
	}

}
