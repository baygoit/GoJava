package ua.com.goit.gojava7.kickstarter.models;

public class Reward {

	private Long id;
	private int amount;
	private String reward;	
	private Long projectId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "id: " + id + "; Amount: " + amount + "; Reward: " + reward + "; projectId: " + projectId;
	}
}
