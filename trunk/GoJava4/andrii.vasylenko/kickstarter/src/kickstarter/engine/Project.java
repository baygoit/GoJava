package kickstarter.engine;

public class Project implements Data {
	private static int count = 0;

	public static final Project EXIT = new Project("EXIT");

	private int id;
	private String name;
	private String description;
	private Category category;
	private int totalAmount;
	private int daysLeft;
	private int collectAmount;
	private String history;
	private String link;
	private String questionsAndAnswers;

	private Project(String name) {
		this.id = count++;
		this.name = name;
	}

	public Project(String name, String description, Category category, int totalAmount, int daysLeft) {
		this(name);

		if (name == null || description == null || category == null || totalAmount <= 0 || daysLeft <= 0) {
			throw new IllegalArgumentException();
		}

		this.description = description;
		this.category = category;
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

	public Category getCategory() {
		return category;
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
