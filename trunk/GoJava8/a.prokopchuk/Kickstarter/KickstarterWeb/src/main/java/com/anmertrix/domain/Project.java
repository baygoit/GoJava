package com.anmertrix.domain;

public class Project {
	private int id;
	private String name;
	private String description;
	private int requiredBudget;
	private long gatheredBudget;
	private int daysLeft;
	private String history;
	private String url;
	private StringBuilder questionAnswer = new StringBuilder();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequiredBudget() {
		return requiredBudget;
	}

	public void setRequiredBudget(int requiredBudget) {
		this.requiredBudget = requiredBudget;
	}

	public long getGatheredBudget() {
		return gatheredBudget;
	}

	public void setGatheredBudget(long count) {
		this.gatheredBudget = count;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuestionAnswer() {
		return questionAnswer.toString();
	}

	public void setQuestion(String question) {
		this.questionAnswer.append(question + "\n");
	}

	public void setProjectData(int id, String name, String description,
			int requiredBudget, int gatheredBudget, int daysLeft, String history) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.requiredBudget = requiredBudget;
		this.gatheredBudget = gatheredBudget;
		this.daysLeft = daysLeft;
		this.history = history;
	}
}
