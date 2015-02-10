package ua.com.goit.gojava.kickstarter;

public class Project {

	private String name;
	private int amount;
	private int days;
	private Category category;
	private String description;
	private int exist;
	private String history;
	private String demoVideo;
	private String questionAnswers; // причем тут все сразу

	public Project(String name, int amount, int days, String demoVideo, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
		this.demoVideo = demoVideo; 
		this.history = null;
		this.questionAnswers = null;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setHistory(String history) {
		this.history = history;
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

	public int getAmount() {
		return amount;
	}

	public int getExist() {
		return exist;
	}

	public int getDays() {
		return days;
	}
	
	public void setDemoVideo(String demoVideo) {
		this.demoVideo = demoVideo;
	}
	
	public void addQuestionAnswer(String questionAnswers) {
		if (this.questionAnswers == null) { // если там ничего нет, то надо добавить
			this.questionAnswers = questionAnswers;
		} else {
			this.questionAnswers += '\n' + questionAnswers; // думаю пока для начала хватит
		}
	}

	public String getHistory() {
		return history;
	}

	public String getDemoVideo() {
		return demoVideo;
	}

	public String getQuestionAnswers() {
		return questionAnswers;
	}

	public void donate(int amount) { 
		this.amount -= amount;
	}

}
