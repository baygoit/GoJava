package com.anmertrix.domain;

public class Question {
	
	private int id;
	private int projectId;
	private String question;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int project_id) {
		this.projectId = project_id;
	}

}
