package ua.com.goit.gojava7.kickstarter.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Project {
	
	private int uniqueID;
	private int categoryID;
	private String title;
	private String briefDescription;
	private String fullDescription;
	private String videoLink;
	private int requiredSum;
	private int collectedSum;
	private int daysLeft;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefDescription() {
		return briefDescription;
	}
	
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}
	
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public int getRequiredSum() {
		return requiredSum;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public int getCollectedSum() {
		return collectedSum;
	}
	
	public void setCollectedSum(int someMoney) {
		this.collectedSum += someMoney;
	}
	
	public String getVideoLink() {
		return videoLink;
	}
	
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	
	public void setDeadline(int day, int month, int year) {
		daysLeft = getDaysLeft(day, month, year);
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public int getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	protected int getDaysLeft(int day, int month, int year) {
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
