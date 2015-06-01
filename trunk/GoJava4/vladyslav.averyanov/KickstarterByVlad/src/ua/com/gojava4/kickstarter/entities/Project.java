package ua.com.gojava4.kickstarter.entities;

public class Project {

	private String name;
	private String shortDescription;
	private int goal;
	private int pledged;
	private int daysToGo;
	private String fullDescription;
	private String link;
	private String FAQ;
	private Category category;
	private int id;

	public Project(String name, String shortDescription, int goal, int pledged,
			int daysToGo, String fullDescription, String link, String FAQ,
			Category category, int id) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.fullDescription = fullDescription;
		this.link = link;
		this.FAQ = FAQ;
		this.category = category;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getGoal() {
		return goal;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getId() {
	    return id;
	}
}
