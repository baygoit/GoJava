package ua.com.goit.gojava7.kickstarter.domain;

public class Reward {
	private int id;
	private int projectId;
	private int pledge;
	private String benefit;
	
	public Reward() {
		
	}
	
	public Reward(int id, int projectId) {
		this.id = id;
		this.projectId = projectId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

}
