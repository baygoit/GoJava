package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private Integer goal;
	private Integer pledged;
	private Integer daysToGo;
	private String history;
	private String link;
	private List<Reward> rewards = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	private String categoryName;

	public Project(String name, String description, Integer goal, Integer pledged, Integer daysToGo) {
		this.name = name;
		this.description = description;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;

	}

	public Project(String name, String description, Integer goal, Integer pledged, Integer daysToGo, String history,
			String link) {
		this.name = name;
		this.description = description;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.history = history;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getGoal() {
		return goal;
	}

	public Integer getPledged() {
		return pledged;
	}

	public Integer getDaysToGo() {
		return daysToGo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void addToPledged(int amount) {
		this.pledged += amount;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

}