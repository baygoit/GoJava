package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private final int id;
	private int categoryId;
	private int daysToGo;
	private String description;
	private String owner;
	private int goal;
	private String linkVideo;
	private List<Question> questions;
	private List<Reward> rewards;
	private List<Payment> payments;

	public Project(String name, int id) {
		setName(name);
		this.id = id;
		setCategoryId(0);
		setDaysToGo(40);
		setDescription("");
		setOwner("");
		setGoal(0);
		setLinkVideo("");
		questions = new ArrayList<Question>();
		rewards = new ArrayList<Reward>();
		payments = new ArrayList<Payment>();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getAllDetails() {
		StringBuilder projectDetails = new StringBuilder();

		projectDetails.append("name: ").append(name).append("\n");
		projectDetails.append("funded: ").append(getFunded()).append("\n");
		projectDetails.append("daysToGo: ").append(daysToGo).append("\n");
		projectDetails.append("pledged: ").append(getPledged()).append("\n");
		projectDetails.append("description: ").append(description).append("\n");
		projectDetails.append("owner: ").append(owner).append("\n");
		projectDetails.append("goal: ").append(goal).append("\n");
		projectDetails.append("linkVideo: ").append(linkVideo).append("\n");
		for (Question question : questions) {
			projectDetails.append("Question: '")
					.append(question.getQuestionText()).append("'\n");
		}
		return projectDetails.toString();
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public int questionsSize() {
		return questions.size();
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public Reward getReward(int index) {
		return rewards.get(index);
	}

	public void addReward(Reward reward) {
		rewards.add(reward);
	}

	public int rewardsSize() {
		return rewards.size();
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void addPayment(Payment payment) {
		payments.add(payment);
	}

	public int paymentsSize() {
		return payments.size();
	}

	public int getPledged() {
		int pledged = 0;
		for (Payment payment : payments) {
			pledged += payment.getPledge();
		}
		return pledged;
	}

	public int getFunded() {
		int goal = getGoal();
		return goal == 0 ? 0 : getPledged() * 100 / goal;
	}
}
