package ua.com.goit.gojava7.kickstarter.domain;

public class Project {
	private Category category;
	private String name;
	private String info;
	private int goal;
	private int pledged;
	private int daysToGo;
	private String history;
	private String video;
	private String faq;
	
	public Project(Category category, String name, String info, int goal, 
			int pledged, int daysToGo, String history, String video, String faq) {
		this.category = category;
		this.name = name;
		this.info = info;
		this.pledged = pledged;
		this.goal = goal;
		this.daysToGo = daysToGo;
		this.history = history;
		this.video = video;
		this.faq = faq;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSummary() {
		return info;
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
}
