package ua.com.goit.gojava7.kickstarter.domain;

public class Reward {

	private int amount;
	private String reward;
	private String projectName;

	public Reward(int amount, String reward) {
		this.amount = amount;
		this.reward = reward;
	}

	public int getAmount() {
		return amount;
	}

	public String getReward() {
		return reward;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
