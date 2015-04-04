package ua.com.sas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category_id")
	private int categoryId;

	private String name;
	private String description;

	@Column(name = "money_need")
	private int moneyNeed;
	
	@Column(name = "money_has")
	private int moneyHas;
	
	@Column(name = "days_left")
	private int daysLeft;


	private String history;
	
	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "question")
	private String questions;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
	private Category category;

	public Category getCategory() {
		return category;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMoneyNeed() {
		return moneyNeed;
	}
	
	public void setMoneyNeed(int moneyNeed) {
		this.moneyNeed = moneyNeed;
	}

	public int getMoneyHas() {
		return moneyHas;
	}
	
	public void setMoneyHas(int moneyHas) {
		this.moneyHas = moneyHas;
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

	public String getVideoLink() {
		return videoLink;
	}
	
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
