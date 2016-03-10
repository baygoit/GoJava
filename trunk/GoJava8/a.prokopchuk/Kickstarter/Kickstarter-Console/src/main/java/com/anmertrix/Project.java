package com.anmertrix;

public class Project {
	private String name;
	private String description;
    private int requiredBudget;
    private int gatheredBudget;
    private int daysLeft;
    private String history;
    private String url = "test url";
    private StringBuilder questionAnswer = new StringBuilder();
	
	public Project(String name, String description, int requiredBudget, int gatheredBudget, int daysLeft, String history) {
		this.name = name;
		this.description = description;
		this.requiredBudget = requiredBudget;
		this.gatheredBudget = gatheredBudget;
		this.daysLeft = daysLeft;
		this.history = history;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getRequiredBudget() {
		return requiredBudget;
	}
	public int getGatheredBudget() {
		return gatheredBudget;
	}
	public void setGatheredBudget(int count) {
		this.gatheredBudget = gatheredBudget + count;
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public String getHistory() {
		return history;
	}
	
	public String getURL() {
		return url;
	}
	public void setURL(String url) {
		this.url = url;
	}
	
	public String getQuestionAnswer() {
		return questionAnswer.toString();
	}
	
	public void setQuestion(String question) {
		this.questionAnswer.append(question + "\n");
	}
}
