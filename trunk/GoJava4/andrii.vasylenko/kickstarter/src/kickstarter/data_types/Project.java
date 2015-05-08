package kickstarter.data_types;

public class Project implements Data {
	private static int count = 0;

	private int id;
	private String name;
	private String description;
	private int totalAmount;
	private int collectAmount;
	private int daysLeft;
	private Category category;
	private String history;
	private String link;
	private String questionsAndAnswers;

	public Project(String name, String description, int totalAmount, int collectAmount, int daysLeft, Category category) {
		this.id = ++count;
		this.name = name;
		this.description = description;
		this.totalAmount = totalAmount;
		this.collectAmount = collectAmount;
		this.daysLeft = daysLeft;
		this.category = category;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setQuestionsAndAnswers(String questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}

	@Override
	public int getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public static int getCount() {
		return count;
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
