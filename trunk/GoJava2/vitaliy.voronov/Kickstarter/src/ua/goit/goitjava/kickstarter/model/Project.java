package ua.goit.goitjava.kickstarter.model;

import java.util.ArrayList;

public class Project {
	private String name;
	private String description;
	private int needMoney;
	private int haveMoney;
	private int daysBeforeEnd;
	private String projectHistory;
	private String linkToDemoVideo;
	private Category category;
	private ArrayList<FAQ> faq = new ArrayList<FAQ>();

	public Project(String name, String description, Category category,
			int needMoney, int haveMoney, int daysBeforeEnd,
			String projectHistory, String linkToDemoVideo) {
		this.name = name;
		this.description = description;
		this.needMoney = needMoney;
		this.haveMoney = haveMoney;
		this.daysBeforeEnd = daysBeforeEnd;
		this.projectHistory = projectHistory;
		this.linkToDemoVideo = linkToDemoVideo;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNeedMoney() {
		return needMoney;
	}

	public int getHaveMoney() {
		return haveMoney;
	}

	public int getDaysBeforeEnd() {
		return daysBeforeEnd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNeedMoney(int needMoney) {
		this.needMoney = needMoney;
	}

	public void setHaveMoney(int haveMoney) {
		this.haveMoney = haveMoney;
	}

	public void setDaysBeforeEnd(int daysBeforeEnd) {
		this.daysBeforeEnd = daysBeforeEnd;
	}

	public void setProjectHistory(String projectHistory) {
		this.projectHistory = projectHistory;
	}

	public void setLinkToDemoVideo(String linkToDemoVideo) {
		this.linkToDemoVideo = linkToDemoVideo;
	}

	public void setFaq(ArrayList<FAQ> faq) {
		this.faq = faq;
	}

	public Category getCategory() {
		return category;
	}

	public String getProjectHistory() {
		return projectHistory;
	}

	public String getLinkToDemoVideo() {
		return linkToDemoVideo;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString() {
		return name;
	}

	public String smallProject() {
		String smallProject = name + description + needMoney + haveMoney
				+ daysBeforeEnd;
		return smallProject;
	}

	public void addMoney(int addMoney) {
		this.haveMoney += addMoney;
	}

	public ArrayList<FAQ> getFaq() {
		return faq;
	}

	public void addFAQ(FAQ faq) {
		this.faq.add(faq);

	}

}