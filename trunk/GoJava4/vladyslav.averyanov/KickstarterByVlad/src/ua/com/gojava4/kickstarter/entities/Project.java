package ua.com.gojava4.kickstarter.entities;

public class Project {

	private String name;
	private String shortDescription;
	private int moneyGoal;
	private int pledged;
	private int daysToGo;
	private String fullDescription;
	private String link;
	private String FAQ;
	private int categoryId;
	private int id;
	
	public Project(String name, String shortDescription, int moneyGoal, int pledged,
			int daysToGo, String fullDescription, String link, String FAQ,
			int categoryId, int id) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.moneyGoal = moneyGoal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.fullDescription = fullDescription;
		this.link = link;
		this.FAQ = FAQ;
		this.categoryId = categoryId;
		this.id = id;
	}

	public Project(String name, String shortDescription, int moneyGoal,
			int daysToGo, String fullDescription,
			int categoryId, int id) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.moneyGoal = moneyGoal;
		this.pledged = 0;
		this.daysToGo = daysToGo;
		this.fullDescription = fullDescription;
		this.link = "URL: " + "http://"+ name + "/main";
		this.FAQ = "Questions and answers";
		this.categoryId = categoryId;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getMoneyGoal() {
		return moneyGoal;
	}

	public int getPledged() {
		return pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public String getLink() {
		return link;
	}

	public String getFAQ() {
		return FAQ;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getId() {
	    return id;
	}
}
