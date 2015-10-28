package model;

public class Project {

	private String name;
	private String shortDescription;
	private float needAmount;
	private float currentAmount;
	private int daysLeft;
	private Category category; 
	private String history;
	private String[] questionsAndAnswers;

	public Project() {

	}

	public Project(String name, String shortDescription, float neededAmount,
			float currentAmount, int daysLeft, Category category,
			String history, String[] questionsAndAnswers) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.needAmount = neededAmount;
		this.currentAmount = currentAmount;
		this.daysLeft = daysLeft;
		this.category = category;
		this.history = history;
		this.questionsAndAnswers = questionsAndAnswers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public float getNeededAmount() {
		return needAmount;
	}

	public void setNeededAmount(float neededAmount) {
		this.needAmount = neededAmount;
	}

	public float getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String[] getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(String[] questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}

}
