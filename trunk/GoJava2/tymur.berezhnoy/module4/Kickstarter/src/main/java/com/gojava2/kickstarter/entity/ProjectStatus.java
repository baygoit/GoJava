package com.gojava2.kickstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
@Table(name = "project_status")
public class ProjectStatus {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false, name = "requaried_amount", length = 250)
	private int requiredAmount;
	
	@Column(length = 250)
	private int total;
	
	@Column(nullable = false, name = "days_left", length = 250)
	private int daysLeft;
	
	@Column(length = 250)
	private int backers;
	
	public ProjectStatus() {}
	
	@PersistenceConstructor
	public ProjectStatus(int requiredAmount, int total, int daysLeft, int backers) {
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.daysLeft = daysLeft;
		this.backers = backers;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
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

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}

	public void setBackers(int backers) {
		this.backers = backers;
	}
	
	public int getBackers() {
		return backers;
	}	
}