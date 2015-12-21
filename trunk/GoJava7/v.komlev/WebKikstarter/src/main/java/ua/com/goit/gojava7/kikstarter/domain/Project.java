package ua.com.goit.gojava7.kikstarter.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Project {

	private int uniqueID;
	private int categoryID;
	private String name;
	private String description;
	private String detailedDescription;
	private String url;
	private String question;
	private int necessaryAmount;
	private int collectedAmount;
	private int endOfDays;

	public Project(int uniqueID, int categoryID, String name, int necessaryAmount,
			int collectedAmount) {
		this.uniqueID = uniqueID;
		this.categoryID = categoryID;
		this.name = name;
		this.necessaryAmount = necessaryAmount;
		this.collectedAmount = collectedAmount;
		this.question = "While no one not leave any question";
	}

	public Project() {
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public String getUrl() {
		return url;
	}

	public int getNecessaryAmount() {
		return necessaryAmount;
	}

	public int getCollectedAmount() {
		return collectedAmount;
	}

	public int getEndOfDays() {
		return endOfDays;
	}

	public String getProjectQuestion() {
		return question;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public void setName(String projectName) {
		this.name = projectName;
	}

	public void setDescription(String projectDescription) {
		this.description = projectDescription;
	}

	public void setDetailedDescription(String projectDetailedDescription) {
		this.detailedDescription = projectDetailedDescription;
	}

	public void setUrl(String projectUrl) {
		this.url = projectUrl;
	}

	public void setNecessaryAmount(int projectNecessaryAmount) {
		this.necessaryAmount = projectNecessaryAmount;
	}

	public void setCollectedAmount(int projectCollectedAmount) {
		this.collectedAmount += projectCollectedAmount;
	}

	public void setQuestion(String projectQuestin) {
		this.question = projectQuestin;
	}

	public void setProjectDaysToEnd(int projectDaysToEnd) {
		this.endOfDays = projectDaysToEnd;
	}

	public void setSumFromUser(int enteredAmount) {
		collectedAmount += enteredAmount;
	}

	public void setEndOfDays(int endOfDays) {
		this.endOfDays = endOfDays;
	}

	public int setEndOfDaysProject(int day, int month, int year) {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		Calendar currentCalendar = Calendar.getInstance();
		Date date = new Date();

		currentCalendar.setTimeZone(timeZone);
		currentCalendar.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Math.abs(month - 1));

		long difference = calendar.getTimeInMillis() - currentCalendar.getTimeInMillis();
		long days = difference / (1000 * 60 * 60 * 24);

		return (int) days;
	}

}
