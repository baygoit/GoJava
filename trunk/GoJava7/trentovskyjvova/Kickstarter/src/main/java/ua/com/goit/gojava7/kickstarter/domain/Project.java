package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	@Column
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	@Column
	private int daysToGo;
	@Column
	private String description;
	@Column
	private String owner;
	@Column
	private int goal;
	@Column
	private String videoUrl;
	@Column
	private int amountPledge;
	
	public Project() {
		
	}
	
	public Project(String name, int id) {
		this.name = name;
		this.id = id;

		this.daysToGo = 40;
		this.description = "";
		this.owner = "";
		this.goal = 0;
		this.videoUrl = "";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
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

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getFunded() {
		return goal == 0 ? 0 : getAmountPledge() * 100 / goal;
	}

	public int getAmountPledge() {
		return amountPledge;
	}

	public void setAmountPledge(int amountPledge) {
		this.amountPledge = amountPledge;
	}
}
