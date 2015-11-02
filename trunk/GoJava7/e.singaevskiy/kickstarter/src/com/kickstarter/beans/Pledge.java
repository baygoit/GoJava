package com.kickstarter.beans;

import java.util.Date;

public class Pledge {
	private Long pledgeSum;
	private User user;
	private Reward reward;
	private Project project;
	private Date date;

	public Long getPledgeSum() {
		return pledgeSum;
	}

	public void setPledgeSum(Long pledgeSum) {
		this.pledgeSum = pledgeSum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
