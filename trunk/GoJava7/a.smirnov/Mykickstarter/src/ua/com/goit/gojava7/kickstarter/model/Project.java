package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import ua.com.goit.gojava7.kickstarter.storage_in_memory.FaqStorage;
import ua.com.goit.gojava7.kickstarter.templates.Templateble;

public class Project implements Comparable<Project>, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Category category;
	private String title;
	private String briefDescription;
	private String fullDescription;
	private String linkOnVideo;
	private int requiredAmountOfMoney;
	private int currentAmountOfMoney;
	private int expiryDays;

	public Project(String title, String briefDescription, 
			int requiredAmountOfMoney) {
		
		this.title = title;
		this.briefDescription = briefDescription;
		this.requiredAmountOfMoney = requiredAmountOfMoney;		
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
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Faq> getAllFaqsFromProject(Templateble<Faq> templateble) {
		Set<Faq> allFaqs = templateble.getAll();
		
		Set<Faq> allFaqsFromSelectedProject = new TreeSet<>();
		
		Iterator<Faq> iteratorFaq = allFaqs.iterator();
		
		while (iteratorFaq.hasNext()) {
			Faq faq = iteratorFaq.next();
			if (faq.getProject().getTitle().equals(title)) {
				allFaqsFromSelectedProject.add(faq);
			}
		}
		
		return allFaqsFromSelectedProject;
	}
	
	@Override
	public int compareTo(Project that) {
		return this.getTitle().compareTo(that.getTitle());
	}
}
