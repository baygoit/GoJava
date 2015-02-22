package ua.home.kickstarter.content;

public class Project {
	private String name;
	private int id;
	private int goal;
	private int pledged;
	private int daysLeft;
	private String description;
	private String history;
	private String linksToVideo;
	private String questionAnswers;

	public Project() {
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setQuestionAnswers(String questionAnswers) {
		if (this.questionAnswers == null) {
			this.questionAnswers = questionAnswers;
		} else {
			this.questionAnswers += '\n' + questionAnswers;
		}
	}

	public int getPledged() {
		return pledged;
	}

	public String getName() {
		return name;
	}

	public void addPayment(int i) {
		this.pledged += i;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLinksToVideo() {
		return linksToVideo;
	}

	public void setLinksToVideo(String linksToVideo) {
		this.linksToVideo = linksToVideo;
	}

	public String getHistory() {
		return history;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionAnswers() {
		return questionAnswers;
	}
}
