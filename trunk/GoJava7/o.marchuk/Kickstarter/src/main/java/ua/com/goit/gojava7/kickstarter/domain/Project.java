package ua.com.goit.gojava7.kickstarter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Project {

	private String name;
	private String shortDescription;
	private long requiredAmount;
	private long gatheredAmount;
	private int daysLeft;
	private String history = "";
	private String videoUrl = "";
	private String questionsAndAnswers = "";

	public Project(String name, String shortDescription, long requiredAmount, int daysLeft) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.requiredAmount = requiredAmount;
		this.daysLeft = daysLeft;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public long getRequiredAmount() {
		return requiredAmount;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(String questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}

	public long getGatheredAmount() {
		return gatheredAmount;
	}

	public void setGatheredAmount(long gatheredAmount) {
		this.gatheredAmount = gatheredAmount;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("shortDescription", shortDescription)
				.append("requiredAmount", requiredAmount).append("gatheredAmount", gatheredAmount).append("daysLeft", daysLeft)
				.toString();
	}
}
