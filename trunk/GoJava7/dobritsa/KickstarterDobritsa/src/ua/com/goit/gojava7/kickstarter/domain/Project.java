package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private Integer goal;
	private Integer pledged;
	private Integer daysToGo;
	private String history;
	private String link;
	private List<Reward> rewards = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	
	public Project() {
	}

	public Project(String name, String description, Integer goal, Integer pledged, Integer daysToGo, String history,
			String link) {
		this.name = name;
		this.description = description;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.history = history;
		this.link = link;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer goal) {
		this.goal = goal;
	}

	public Integer getPledged() {
		return pledged;
	}

	public void setPledged(Integer pledged) {
		this.pledged = pledged;
	}

	public Integer getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(Integer daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	
	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}	
	
	public void addToPledged(int amount) {
		this.pledged += amount;
	}
	
	String questionFile;

	public void setQuestionFile(String questionFile) {
		this.questionFile = questionFile;
	}

	public String getQuestionFile() {
		return questionFile;
	}

	public String getRewardFile() {
		return rewardFile;
	}

	String rewardFile;

	public void setRewardFile(String rewardFile) {
		this.rewardFile = rewardFile;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

}