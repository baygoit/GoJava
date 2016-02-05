package com.sandarovich.kickstarter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Olexamder Kolodiazhny 2016 Describes Project entitity.
 * 	 Builder pattern  used.
 */

public class Project {

	private final int id;
	private final Category category;
	private final String description;
	private final String shortDesription;
	private final double goalAmount;
	private final double collectedAmount;
	private final Calendar goalDate;
	private final String videoLink;
	private final String history;
	private final String questionsAnswers;

	public static class Builder {
		// Required fields
		private final int id;
		private final Category category;
		
		// Optional fields
		private String description = "";
		private String shortDesription = "";
		private double goalAmount = 0d;
		private double collectedAmount = 0d;
		private Calendar goalDate = new GregorianCalendar(2016, 2, 1);
		
		private String videoLink = "http:\\";
		private String history = "No history";
		private String questionsAnswers = "No Q&A";

		public Builder(int id, Category category) {
			this.id = id;
			this.category = category;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}
	
		public Builder shortDescription(String shortDescription) {
			this.shortDesription = shortDescription;
			return this;
		}
		
		public Builder goalAmount(double goalAmount) {
			this.goalAmount = goalAmount;
			return this;
		}
		
		public Builder collectedAmount(double collectedAmount) {
			this.collectedAmount = collectedAmount;
			return this;
		}
		
		public Builder goalDate(Calendar goalDate) {
			this.goalDate = goalDate;
			return this;
		}
		
		public Builder videoLink(String videoLink) {
			this.videoLink = videoLink;
			return this;
		}
		
		public Builder history(String history) {
			this.history = history;
			return this;
		}
		
		public Builder questionsAnswers(String questionsAnswers) {
			this.questionsAnswers = questionsAnswers;
			return this;
		}
		
		

		public Project build() {
			return new Project(this);
		}

	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public String getShortDescription() {
		return this.shortDesription;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getGoalAmount() {
		return goalAmount;
	}
	
	public double getcollectedAmount() {
		return collectedAmount;
	}
	
	public int getGoalDateDays(){
		int result = 0;
		
		Calendar now = Calendar.getInstance();
		
		result = (int) ((goalDate.getTimeInMillis() - now.getTimeInMillis())/ (24 * 60 * 60 * 1000));;
	
		return result;
	}
	
	
	private Project(Builder builder) {
		// Required parameters
		id = builder.id;
		category = builder.category;
		// Optional parameters
		description = builder.description;
		shortDesription = builder.shortDesription;
		goalAmount = builder.goalAmount;
		collectedAmount = builder.collectedAmount;
		goalDate = builder.goalDate;
		videoLink = builder.videoLink;
		history = builder.history;
		questionsAnswers = builder.questionsAnswers;

	}

	

}
