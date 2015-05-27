package com.goit.kickstarter.glmax.view;

import com.goit.kickstarter.glmax.model.QuestionsAndAnswers;

public class Project {
	private int id;
	private String name;
	private String shortDescription;
	private int amountNeeded;
	private int amountCollected;
	private int daysLeft;
	private String history;
	private String videoURL;
	private QuestionsAndAnswers questionsAndAnswers;
	
	public Project(int id, String name, String shortDescription,
			int amountNeeded, int amountCollected, int daysLeft,
			String history, String videoURL,
			QuestionsAndAnswers questionsAndAnswers) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.amountNeeded = amountNeeded;
		this.amountCollected = amountCollected;
		this.daysLeft = daysLeft;
		this.history = history;
		this.videoURL = videoURL;
		this.questionsAndAnswers = questionsAndAnswers;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public int getAmountNeeded() {
		return amountNeeded;
	}
	public int getAmountCollected() {
		return amountCollected;
	}
	public int getDaysLeft() {
		return daysLeft;
	}
	public String getHistory() {
		return history;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public QuestionsAndAnswers getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

}
