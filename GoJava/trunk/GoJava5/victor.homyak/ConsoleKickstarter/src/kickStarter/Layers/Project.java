package kickStarter.Layers;
// I have stolen this class from classmate Nikolay ))
public class Project {
	private String name;
	private String description;
	private int amountRequired;
	private int amountCollected;
	private int daysLeft;
	private Category category;
	private String projectHistory;
	private String linkToVideo;
	private String questionsAnswers;

	public Project(String name) {
		this.name = name;
		description = "";
		amountRequired = 0;
		amountCollected = 0;
		daysLeft = 0;
		projectHistory = "";
		linkToVideo = "";
		questionsAnswers = "";
	}

	public Project(String name, String desc, int required, int collected, int days) {
		this.name = name;
		description = desc;
		amountRequired = required;
		amountCollected = collected;
		daysLeft = days;
		projectHistory = "";
		linkToVideo = "";
		questionsAnswers = "";
	}

	public void setCategory(Category cat) {
		category = cat;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		if (description.isEmpty()) {
			return "...";
		}
		return description;
	}

	public int getRequiredAmount() {
		return amountRequired;
	}

	public int getCollectedAmount() {
		return amountCollected;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setHistory(String history) {
		projectHistory = history;
	}

	public void setLink(String link) {
		linkToVideo = link;
	}

	public void setQuestionsAnswers(String qa) {
		questionsAnswers = qa;
	}

	public String getHistory() {
		if (projectHistory.isEmpty()) {
			return "...";
		}
		return projectHistory;
	}

	public String getLink() {
		if (linkToVideo.isEmpty()) {
			return "-/-";
		}
		return linkToVideo;
	}

	public String getQuestionsAnswers() {
		if (questionsAnswers.isEmpty()) {
			return "N/A";
		}
		return questionsAnswers;
	}
}
