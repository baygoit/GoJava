package com.anmertrix.domain;

import java.util.List;

public class Question {
	
	private int id;
	private int projectId;
	private String question;
	private List<Answer> answers;
	
	public int getId() {
		return id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
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
