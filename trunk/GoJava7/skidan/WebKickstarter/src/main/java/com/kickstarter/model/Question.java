package com.kickstarter.model;

public class Question {
	private String question;
	private String projectTitle;
	
	
	public Question() {
		
	}

	public Question(String question, String projectTitle) {
		this.question = question;
		this.projectTitle = projectTitle;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	
	public String toString() {
		return question ;
	}

}
