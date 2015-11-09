package com.kickstarter.beans;

import java.util.Date;

public class Pledge {
	private Reward reward;
	private Project project;
	private Payment payment;

	public Pledge(Project project, Payment payment) {
		this.project = project;
		this.payment = payment;
	}

	public long getPledgeSum() {
		return payment.getSum();
	}

	public User getUser() {
		return payment.getUser();
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
		return payment.getDate();
	}

}
