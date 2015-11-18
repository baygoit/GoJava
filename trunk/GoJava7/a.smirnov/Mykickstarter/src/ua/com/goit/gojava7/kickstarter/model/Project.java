package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import ua.com.goit.gojava7.kickstarter.templates.Templateble;

public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int uniqueID;
	private int categoryID;
	private String title;
	private String briefDescription;
	private String fullDescription;
	private String videoLink;
	private int requiredSum;
	private int collectedSum;
	private int dayLeft;

	public Project(String title, String briefDescription, int requiredSum) {
		this.categoryID = Integer.MIN_VALUE;
		this.title = title;
		this.briefDescription = briefDescription;
		this.fullDescription = "----";
		this.videoLink = "----";
		this.requiredSum = requiredSum;	
		this.collectedSum = 0;
		this.dayLeft = 0;
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

	public int getRequiredSum() {
		return requiredSum;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public int getCollectedSum() {
		return collectedSum;
	}
	
	public void donateMoney(int someMoney) {
		this.collectedSum += someMoney;
	}
	
	public String getVideoLink() {
		return videoLink;
	}
	
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	
	public void setDeadline(int day, int month, int year) {
		dayLeft = getDaysLeft(day, month, year);
	}
	
	public int getDaysLeft() {
		return dayLeft;
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
	
//	protected Set<Faq> getAllFaqsFromProject(Templateble<Faq> templateble) {
//		Set<Faq> allFaqs = templateble.getAll();
//		
//		Set<Faq> allFaqsFromSelectedProject = new TreeSet<>();
//		
//		Iterator<Faq> iteratorFaq = allFaqs.iterator();
//		
//		while (iteratorFaq.hasNext()) {
//			Faq faq = iteratorFaq.next();
//			if (faq.getProject().getTitle().equals(title)) {
//				allFaqsFromSelectedProject.add(faq);
//			}
//		}
//		
//		return allFaqsFromSelectedProject;
//	}
}
