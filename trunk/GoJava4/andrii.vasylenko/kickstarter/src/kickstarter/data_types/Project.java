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

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " - " + name + ", description=" + description + ", totalAmount=" + totalAmount + ", collectAmount="
				+ collectAmount + ", daysLeft=" + daysLeft + "]";
	}

	public String getDetailedDescription() {
		StringBuilder result = new StringBuilder();

		result.append("name=");
		result.append(name);
		result.append("\r\n description=");
		result.append(description);
		result.append("\r\n totalAmount=");
		result.append(totalAmount);
		result.append("\r\n collectAmount=");
		result.append(collectAmount);
		result.append("\r\n daysLeft=");
		result.append(daysLeft);
		result.append("\r\n history=");
		result.append(history);
		result.append("\r\n link=");
		result.append(link);
		result.append("\r\n questionsAndAnswers=");
		result.append(questionsAndAnswers);

		return result.toString();
	}

	public Category getCategory() {
		return category;
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

}
