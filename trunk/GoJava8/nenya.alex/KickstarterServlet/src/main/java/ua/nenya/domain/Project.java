package ua.nenya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	private int id;
	@Column(name = "category_id")
	private int categoryId;
	@Column
	private String name;
	@Column
	private String description;
	@Column(name = "needed_amount")
	private int neededAmount;
	@Column(name = "remaining_days")
	private int remainingDays;
	@Column
	private String history;
	@Column
	private String video;
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNeededAmount() {
		return neededAmount;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setNeededAmount(int allAmount) {
		this.neededAmount = allAmount;
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

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

}
