package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Project {

	private List<String> projectCategories;
	private String projectName;
	private String briefDescription;
	private String fullDescription;
	private double requiredAmountOfMoney;
	private double currentAmoutOfMoney;
	private int expireProjectDate;
	private int day, month, year;

	public Project() {
		projectCategories = new ArrayList<>();
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setTitle(String title) {
		this.projectName = title;
	}

	public String getTitle() {
		return projectName;
	}

	public double getRequiredAmountOfMoney() {
		return requiredAmountOfMoney;
	}

	public void setRequiredAmountOfMoney(double money) {
		this.requiredAmountOfMoney = money;
	}

	public void setCurrentAmoutOfMoney(double money) {
		this.currentAmoutOfMoney += money;
	}

	public double getCurrentAmoutOfMoney() {
		return currentAmoutOfMoney;
	}

	public int getDaysLeft() {
		Date date = new Date();
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MONTH, (month - 1));

		long diff = calendar.getTimeInMillis() - currentCalendar.getTimeInMillis();
		long days = diff / (1000 * 60 * 60 * 24);
		return Math.abs((int) days);
	}

	public void setExpireProjectDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;

		this.expireProjectDate = getDaysLeft();
	}

	public int getExpireProjectDate() {
		return expireProjectDate;
	}

	public void setProjectCategory(String categoryName) {
		projectCategories.add(categoryName);
	}

	public List<String> getCategories() {
		return Collections.unmodifiableList(projectCategories);
	}
}
