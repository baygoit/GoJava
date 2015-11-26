package ua.com.goit.gojava7.kickstarter.domain;

public class Reward {

	private int amount;
	private String reward;
	private String projectName;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
