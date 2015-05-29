package com.ivanpozharskyi.kickstarter.datastorage;

public class Project {
	private static int counter = 0;
	private int id;
	private String name;
	private String descripyion;
	private int moneyGot;
	private int moneyNeed;
	private int daysLeft;
	private Category category;
	private String video;
	private QuestionStorage questionStorage = new QuestionStorage();

	public Project(String name, int moneyGot, int moneyNeed, int daysLeft,
			Category category) {
		this.id = ++counter;

		this.name = name;
		this.moneyGot = moneyGot;
		this.moneyNeed = moneyNeed;
		this.daysLeft = daysLeft;
		this.category = category;
	}

	public String getDetailDescription() {
		String result = "id: " + id + " Name: " + name + " description: "
				+ descripyion + " moneyGot: " + moneyGot + " moneyNeed: "
				+ moneyNeed + " daysLeft: " + daysLeft + " quastions: "
				+ questionStorage.toString() + " video: " + video;
		return result;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		String result = "id: " + id + " Name: " + name + " description: "
				+ descripyion + " moneyGot: " + moneyGot + " moneyNeed: "
				+ moneyNeed + " daysLeft: " + daysLeft + " category: "
				+ category.getName();

		return result;

	}

	public Category getCaegory() {
		return category;
	}

	public void addQuestion(Question question) {
		questionStorage.addQustion(question);
	}

	public int getProjectId(Project project) {
		return project.id;
	}

	public void addQuestionAndAnswers(QuestionStorage questionStorage) {
		this.questionStorage = questionStorage;
		
	}
}
