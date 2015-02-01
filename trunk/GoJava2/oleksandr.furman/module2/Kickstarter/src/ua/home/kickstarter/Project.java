package ua.home.kickstarter;

import org.json.simple.JSONObject;

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

	public Project(JSONObject jsonObject) {
		this.name = "" + jsonObject.get("name");
		this.description = "" + jsonObject.get("description");
		this.goal = Integer.parseInt("" + jsonObject.get("goal"));
		this.daysLeft = Integer.parseInt("" + jsonObject.get("daysLeft"));
		this.history = "" + jsonObject.get("history");
		this.linksToVideo = "" + jsonObject.get("linksToVideo");
		this.pledged = 0;
		this.questions = "тут пока пусто";
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
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
