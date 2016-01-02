package com.kickstarter.model;

public class Question {

	private int id;
	private String question;
	private Project project;

	public Question() {

	}

	public Question(String question, Project project) {
		this.question = question;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getProjectId() {
	// return projectId;
	// }
	//
	// public void setProjectId(int projectId) {
	// this.projectId = projectId;
	// }

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String toString() {
		return question;
	}

}
