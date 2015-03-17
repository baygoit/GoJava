package ua.com.goit.gojava.alexfurman.kickstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 1000)
	private String name;

	@Column(length = 5000)
	private String description;

	private int goal;

	private int pledged;
	
	@Column(name = "days_left")
	private int daysLeft;

	@Column(length = 5000)
	private String history;

	@Column(length = 1000, name = "links_to_video")
	private String linksToVideo;

	@Column(length = 5000, name = "question_answers")
	private String questionAnswers;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getPledged() {
		return pledged;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLinksToVideo() {
		return linksToVideo;
	}

	public void setLinksToVideo(String linksToVideo) {
		this.linksToVideo = linksToVideo;
	}

	public String getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(String questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

}
