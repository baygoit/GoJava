package ua.com.goit.gojava7.kickstarter.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Project implements Comparable<Project> {
	private String title;
	private String briefDescription;
	private String fullDescription;
	private String linkOnVideo;
	private String question;
	private String answer;
	private int requiredAmountOfMoney;
	private int currentAmountOfMoney;
	private int expiryDays;

	public Project(String title, String briefDescription, int requiredAmountOfMoney) {
		this.title = title;
		this.briefDescription = briefDescription;
		this.requiredAmountOfMoney = requiredAmountOfMoney;
		
		this.fullDescription = "";
		this.linkOnVideo = "";
		this.question = "";
		this.answer = "";
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefDescription() {
		return briefDescription;
	}
	
	public void addBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}
	
	public void addFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public int getRequiredAmountOfMoney() {
		return requiredAmountOfMoney;
	}

	public void setRequiredAmountOfMoney(int money) {
		this.requiredAmountOfMoney = money;
	}

	public int getCurrentAmoutOfMoney() {
		return currentAmountOfMoney;
	}
	
	public void addToCurrentAmountOfMoney(int money) {
		this.currentAmountOfMoney += money;
	}
	
	public String getLinkOnVideo() {
		return linkOnVideo;
	}
	
	public void addLinkOnVideo(String linkOnVideo) {
		this.linkOnVideo = linkOnVideo;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void addAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void addQuestion(String question) {
		this.question = question;
	}
	
	public void setExpiryDays(int day, int month, int year) {
		expiryDays = getDaysLeft(day, month, year);
	}
	
	public int getExpiryDays() {
		return expiryDays;
	}
	
	public int getDaysLeft(int day, int month, int year) {
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

		return (int)days;
	}

	@Override
	public int compareTo(Project that) {
		return this.getTitle().compareTo(that.getTitle());
	}
}
