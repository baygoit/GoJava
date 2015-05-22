package kickstarter.engine;

import kickstarter.interfaces.display.Display;
import kickstarter.interfaces.display.ProjectDisplay;
import kickstarter.interfaces.display.ProjectsDisplay;

public class Project implements Data {
	public static Display<Project> DISPLAY = new ProjectsDisplay();
	public static Display<Project> DETAIL_DISPLAY = new ProjectDisplay();
	
	private static int count = 0;

	public static final Project EXIT = new Project("EXIT");

	private int id;
	private String name;
	private String description;
	private int totalAmount;
	private int daysLeft;
	private int collectAmount;
	private String history;
	private String link;
	private String questionsAndAnswers;

	private Project(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}

		this.id = count++;
		this.name = name;
	}

	public Project(String name, String description, int totalAmount, int daysLeft) {
		this(name);

		if (description == null || totalAmount <= 0 || daysLeft <= 0) {
			throw new IllegalArgumentException();
		}

		this.description = description;
		this.totalAmount = totalAmount;
		this.daysLeft = daysLeft;
		this.collectAmount = 0;
		this.history = "";
		this.link = "";
		this.questionsAndAnswers = "";
	}

	public void setHistory(String history) {
		if (history == null) {
			throw new IllegalArgumentException();
		}
		this.history = history;
	}

	public void setLink(String link) {
		if (link == null) {
			throw new IllegalArgumentException();
		}
		this.link = link;
	}

	public void setQuestionsAndAnswers(String questionsAndAnswers) {
		if (questionsAndAnswers == null) {
			throw new IllegalArgumentException();
		}
		this.questionsAndAnswers = questionsAndAnswers;
	}

	public void donate(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException();
		}
		collectAmount += amount;
	}

	@Override
	public int getId() {
		return id;
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

	public String getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}
}
