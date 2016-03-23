package ua.nenya.project;

import java.util.ArrayList;
import java.util.List;

public class Project implements GettingNameInterface {
	private String name;
	private String description;
	private int allAmount;
	private int availableAmount;
	private int daysRemain;
	private String history = "";
	private String video = "";
	private String questionAnswer = "";
	private List<Reward> rewards = new ArrayList<>(); 
	
	public Project() {
	}

	public Project(String name, String description, int allAmount,
			int availableAmount, int daysRemain) {
		this.name = name;
		this.description = description;
		this.allAmount = allAmount;
		this.availableAmount = availableAmount;
		this.daysRemain = daysRemain;
		rewards.add(new Reward("Any amount", ""));
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAllAmount() {
		return allAmount;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}
	
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}

	public int getDaysRemain() {
		return daysRemain;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public List<Reward> getRewards() {
		return rewards;
	}
	
}
