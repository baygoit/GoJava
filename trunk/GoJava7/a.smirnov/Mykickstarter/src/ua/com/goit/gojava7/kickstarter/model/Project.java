package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Project {
	
	private List<Category> listOfCategories;
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

	public Project(String title, String briefDescription, int requiredAmountOfMoney, int exparationDay,
			int exparationMonth, int exparationYear) {

		listOfCategories = new ArrayList<>();
		this.title = title;
		this.briefDescription = briefDescription;
		this.requiredAmountOfMoney = requiredAmountOfMoney;
		this.currentAmountOfMoney = 0;
		this.exparationDay = exparationDay;
		this.exparationMonth = exparationMonth;
		this.exparationYear = exparationYear;
		
		this.fullDescription = "";
		this.linkOnVideo = "";
		this.question = "";
		this.answer = "";
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void addFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getRequiredAmountOfMoney() {
		return requiredAmountOfMoney;
	}

	public void setRequiredAmountOfMoney(int money) {
		this.requiredAmountOfMoney = money;
	}

	public void addToCurrentAmountOfMoney(int money) {
		this.currentAmountOfMoney += money;
	}

	public int getCurrentAmoutOfMoney() {
		return currentAmountOfMoney;
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

	public void addCategoryToProject(Category category) {
		listOfCategories.add(category);
	}
	
	public void deleteCategoryFromProject(Category category) {
		
	}

	public List<Category> getCategories() {
		return listOfCategories;
	}
}
