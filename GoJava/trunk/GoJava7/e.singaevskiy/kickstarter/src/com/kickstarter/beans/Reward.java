package com.kickstarter.beans;

public class Reward {
	private Long pledgeSum;
	private String description;

	public Long getPledgeSum() {
		return pledgeSum;
	}

	public void setPledgeSum(Long pledgeSum) {
		this.pledgeSum = pledgeSum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
