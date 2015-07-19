package goit5.nikfisher.kickstarter.model;

public class Project {

	private String question;
	private String ansver;
	private String name;
	private String description;
	private int amount;
	private int exist;
	private int days;
	private Category category;
	private String history;
	private String video;


	public Project(String name, int amount, int days, String description) {
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
		this.history = null;
		this.video = null;
		this.question = null;
		this.ansver = null;
	}

	public Project(String name){
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	public void setAnsver(String ansver) {
		this.ansver = ansver;
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

	public String getHistory() {
		return history;
	}

	public String getVideo() {
		return video;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnsver() {
		return ansver;
	}

	//	public String getFAQ() {
//		return faq;
//	}

	public void donate(int amount){
		this.amount -= amount;
	}
	public void question(String question){
		this.question = question;
	}

}
