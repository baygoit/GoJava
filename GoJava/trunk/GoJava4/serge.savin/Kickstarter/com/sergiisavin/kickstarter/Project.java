package com.sergiisavin.kickstarter;

import java.util.Date;


public class Project {

	private static int DEFAULT_LIFE_TIME_MONTH = 6;
	
	private String name;
	private String startedDate;
	private String expireDate;
	private double targetSumm;
	private double currentSumm;
	private String description;
	private String projectHistory;
	private String videoURL;
	private String questionsAnswers;
	private String categoryName;
	
	public Project(String name, String startDate, String expireDate, double targetSumm,
			String category) {
		
		this(name, startDate, expireDate, targetSumm, 0.0, category, "NO DESCRIPTION",
				"NO PROJECT HISTORY", "NO VIDEO URL", "NO QUESTIONS AND ANSWERS");
	}

	@SuppressWarnings("deprecation")
	public Project(String name, String startedDate, String expireDate, double targetSumm,
			double currentSumm, String category, String description, String projectHistory,
			String videoURL, String questionsAnswers) {
		
		this.name = name;
		this.startedDate = startedDate;
		this.expireDate = expireDate;
		this.targetSumm = targetSumm;
		this.categoryName = category;
		this.currentSumm = currentSumm;
		this.description = description;
		this.projectHistory = projectHistory;
		this.videoURL = videoURL;
		this.questionsAnswers = questionsAnswers;
	}

	@Override
	public String toString() {
		return "Project Name: " + name + "\n" + "Category: " + categoryName; 
	}

	public String getName() {
		return name;
	}

	public String getStartedDate() {
		return startedDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public double getTargetSumm() {
		return targetSumm;
	}

	public double getCurrentSumm() {
		return currentSumm;
	}

	public String getDescription() {
		return description;
	}

	public String getProjectHistory() {
		return projectHistory;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public String getQuestionsAnswers() {
		return questionsAnswers;
	}

	public String getCategoryName() {
		return categoryName;
	}
}
