package ua.com.goit.gojava7.kikstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "seq_id", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private int id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private int categoryID;

	@Column(name = "name")
	private String name;

	@Column(name = "general_description")
	private String generalDescription;

	@Column(name = "full_description")
	private String fullDescription;

	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "required_sum")
	private int requiredSum;

	@Column(name = "collected_sum")
	private int collectedSum;

	@Column(name = "days_left")
	private int endOfDays;

	public int getId() {
		return id;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getName() {
		return name;
	}

	public String getGenerelDescription() {
		return generalDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public int getRequiredSum() {
		return requiredSum;
	}

	public int getCollectedSum() {
		return collectedSum;
	}

	public int getEndOfDays() {
		return endOfDays;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public void setName(String projectName) {
		this.name = projectName;
	}

	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public void setCollectedSum(int collectedAmount) {
		this.collectedSum = collectedAmount;
	}

	public void setSumFromUser(int enteredAmount) {
		collectedSum += enteredAmount;
	}

	public void setEndOfDays(int endOfDays) {
		this.endOfDays = endOfDays;
	}

	@Override
	public String toString() {
		return "Project: name: " + name + "; general description: " + generalDescription + "; full description: "
				+ fullDescription + "; video link: " + videoLink + "; required sum: " + requiredSum
				+ "; collected sum: " + collectedSum + "; days left: " + endOfDays;
	}

}
