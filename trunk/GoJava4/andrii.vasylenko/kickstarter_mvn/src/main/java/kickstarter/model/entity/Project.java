package kickstarter.model.entity;

import java.util.List;

public class Project {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private int totalAmount;
	private int daysLeft;
	private int collectAmount;
	private String history;
	private String link;
	private List<String> questionsAndAnswers;

	public Project(int id, int categoryId, String name, String description, int totalAmount, int daysLeft,
			String history, String link, List<String> questionsAndAnswers, int collectAmount) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.totalAmount = totalAmount;
		this.daysLeft = daysLeft;
		this.collectAmount = 0;
		this.history = history;
		this.link = link;
		this.questionsAndAnswers = questionsAndAnswers;
		this.collectAmount = collectAmount;
	}

	public int getId() {
		return id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public int getCollectAmount() {
		return collectAmount;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public String getLink() {
		return link;
	}

	public List<String> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}
}
