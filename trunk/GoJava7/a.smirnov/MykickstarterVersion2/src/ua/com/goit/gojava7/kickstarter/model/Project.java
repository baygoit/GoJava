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
	private int exparationDay;
	private int exparationMonth;
	private int exparationYear;

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

	public void addLinkOnVideo(String linkOnVideo) {
		this.linkOnVideo = linkOnVideo;
	}
	
	public String getLinkOnVideo() {
		return linkOnVideo;
	}
	
	public void addQuestion(String question) {
		this.question = question;
	}
	
	public void addAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public int getDaysLeft() {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		Calendar currentCalendar = Calendar.getInstance();
		Date date = new Date();
		
		currentCalendar.setTimeZone(timeZone);
		currentCalendar.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, exparationDay);
		calendar.set(Calendar.YEAR, exparationYear);
		calendar.set(Calendar.MONTH, Math.abs(exparationMonth - 1));

		long difference = calendar.getTimeInMillis() - currentCalendar.getTimeInMillis();
		long days = difference / (1000 * 60 * 60 * 24);

		return (int)days;
	}
	
	public void deleteCategoryFromProject(Category category) {
		
	}

	@Override
	public int compareTo(Project that) {
		return this.getTitle().compareTo(that.getTitle());
	}

}
