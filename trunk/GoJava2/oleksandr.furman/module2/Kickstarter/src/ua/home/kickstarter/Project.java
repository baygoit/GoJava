package ua.home.kickstarter;

public class Project {
	private String name;
	private int goal;
	private int pledged;
	private int daysLeft;
	private String description;
	private String history;
	private String linksToVideo;
	private String questions;
	private Category category; 
	
	public Project(String name, int goal, int daysLeft, String description, String history, String linksToVideo) {
		this.name = name;
		this.goal = goal;
		this.daysLeft = daysLeft;
		this.description = description;
		this.history = history;
		this.linksToVideo = linksToVideo;
		this.pledged = 0;
		this.questions = "тут пока пусто";
	}

	public void setCategory(Category category) {
		this.category = category;		
	}

	public Object getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getGoal() {
		return goal;
	}

	public int getPledged() {
		return pledged;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public String getLinksToVideo() {
		return linksToVideo;
	}

	public String getQuestions() {
		return questions;
	}

}
