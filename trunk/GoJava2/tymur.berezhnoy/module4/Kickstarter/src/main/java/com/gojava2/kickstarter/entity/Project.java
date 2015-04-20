package com.gojava2.kickstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	

	@Transient
	private final char symbolDollar = 36;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(length = 500)
	private String description;
	
	@Column(length = 500)
	private String story;
	
	@Column(length = 250)
	private String link;
	
	@Column(nullable = false, name = "requaried_amount", length = 250)
	private int requiredAmount;
	
	@Column(length = 250)
	private int total;
	
	@Column(nullable = false, name = "days_left", length = 250)
	private int daysLeft;
	
	@Column(length = 250)
	private int backers;
	
	public Project() {}
	
	@PersistenceConstructor
	public Project(String name, String description, int requiredAmount, 
			int total, int daysLeft, int backers, String story, String link, Category category) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.daysLeft = daysLeft;
		this.backers = backers;
		this.story = story;
		this.link = link;
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	public String getStory() {
		return story;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}
	
	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}

	public void setBackers(int backers) {
		this.backers = backers;
	}
	
	public int getBackers() {
		return backers;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
	public Category getCategory() {
		return category;
	}
	
	public char getSymbolDollar() {
		return symbolDollar;
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
}