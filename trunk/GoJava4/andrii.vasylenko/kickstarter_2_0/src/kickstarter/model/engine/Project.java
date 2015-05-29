package kickstarter.model.engine;

public class Project {
	private String name;
	private String description;
	private int totalAmount;
	private int daysLeft;
	private int collectAmount;
	private String history;
	private String link;
	private String questionsAndAnswers;

	public Project(String name, String description, int totalAmount, int daysLeft, String history, String link,
			String questionsAndAnswers) {
		this.name = name;
		this.description = description;
		this.totalAmount = totalAmount;
		this.daysLeft = daysLeft;
		this.collectAmount = 0;
		this.history = history;
		this.link = link;
		this.questionsAndAnswers = questionsAndAnswers;
	}

	public void donate(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException();
		}
		collectAmount += amount;
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
