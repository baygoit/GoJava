package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;

public class Project {

	private List<String> projectCategories = new ArrayList<>();
	private CategoryDAO storageOfCategories;
	private String title;
	private String briefDescription;
	private String fullDescription;
	private double requiredAmountOfMoney;
	private double currentAmoutOfMoney;
	private int daysLeft;
	private int day, month, year;

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
		this.title = title;
	}

	public String getTitle() {
		return title;
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

	public int getCalculationDaysLeft() {
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

	public void setFinalDateForFundraising(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;

		this.daysLeft = getCalculationDaysLeft();
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setProjectCategory(String categoryName) {
		projectCategories.add(categoryName);
	}

	public List<String> getCategories() {
		return Collections.unmodifiableList(projectCategories);
	}
}
