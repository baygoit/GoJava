package com.ivanpozharskyi.kickstarter.entity;

public class Project {
	private static int counter = 0;
	private int id;
	private String name;
	private String description;
	private int moneyGot;
	
	private int moneyNeed;
	
	public String getDescription() {
		return description;
	}

	public int getMoneyGot() {
		return moneyGot;
	}

	public int getMoneyNeed() {
		return moneyNeed;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getName() {
		return name;
	}
	
	public String getDescripyion() {
		return description;
	}

	private int daysLeft;
	private Category category;
	private String video;
	private QuestionStorage questionStorage = new QuestionStorage();
	
	public Project(int id,String name, int moneyGot, int moneyNeed, int daysLeft,
			Category category){
		this(name, moneyGot, moneyNeed, daysLeft, category);
		this.id = id;
	}
	public Project(int id,String name, int moneyGot, int moneyNeed, int daysLeft,
			Category category, String description){
		this(name, moneyGot, moneyNeed, daysLeft, category);
		this.id = id;
		this.description = description;
	}
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
				+ description + " moneyGot: " + moneyGot + " moneyNeed: "
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
				+ description + " moneyGot: " + moneyGot + " moneyNeed: "
				+ moneyNeed + " daysLeft: " + daysLeft + " category: "
				+ category.getName();

		return result;

	}
	public int getCategoryId(){
		return category.getId();
	}
	public Category getCategory() {
		return category;
	}

	public void addQuestion(Question question) {
		questionStorage.addQustion(question);
	}



	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addQuestionAndAnswers(QuestionStorage questionStorage) {
		this.questionStorage = questionStorage;
		
	}
}
