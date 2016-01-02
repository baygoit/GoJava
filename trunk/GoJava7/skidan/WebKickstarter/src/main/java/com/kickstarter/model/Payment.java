package com.kickstarter.model;

public class Payment {

	private int id;
	private Project project;
	private int amount;

	public Payment() {
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

	/*public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}*/

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
