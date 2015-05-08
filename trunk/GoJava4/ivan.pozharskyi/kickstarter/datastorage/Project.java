package com.ivanpozharskyi.kickstarter.datastorage;

public class Project {
	private  int id = 0;
	private String name;
	private String descripyion;
	private int moneyGot;
	private int moneyNeed;
	private int daysLeft;
	private Category category;
	private String video;
	private QuestionStorage questionStorage = new QuestionStorage();
	
	public Project(String name, int moneyGot, int moneyNeed, int daysLeft) {
		this.id++;
		this.name = name;
		this.moneyGot = moneyGot;
		this.moneyNeed = moneyNeed;
		this.daysLeft = daysLeft;
	}
	
	public String getDetailDescription(){
		String result = "id: " + id +
				"Name: " + name +
				"description: " + descripyion + 
				"moneyGot: " + moneyGot +
				"moneyNeed: " + moneyNeed +
				"daysLeft: " + daysLeft +
				"quastions: " + questionStorage.toString() +
				"video: " + video;
		return result;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		String result = "id: " + id +
				"Name: " + name +
				"description: " + descripyion + 
				"moneyGot: " + moneyGot +
				"moneyNeed: " + moneyNeed +
				"daysLeft: " + daysLeft;
			
		return result;
		

	}

	public Category getCaegory(){
		return category;
	}

	public void addQuestion(Question question){
		questionStorage.addQustion(question);
	}
	public int getProjectId(Project project){
		return project.id;
	}
}
