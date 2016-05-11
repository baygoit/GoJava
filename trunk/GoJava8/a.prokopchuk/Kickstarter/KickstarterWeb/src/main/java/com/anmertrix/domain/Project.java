package com.anmertrix.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "project")
@NamedQueries({ 
	@NamedQuery(name = "Project.getProjects", query = "SELECT p from Project p where p.category.id=:categoryId"),  
	@NamedQuery(name = "Project.count", query = "SELECT COUNT(p) FROM Project p")
 })
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	private Category category;

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "required_budget")
	private int requiredBudget;
	
	@Transient
	private long gatheredBudget;
	
	@Column(name = "final_date")
	private Date finalDate;
	
	@Transient
	private int daysLeft;
	
	@Column
	private String history;
	
	@Column
	private String url;
	
	@OneToMany(mappedBy = "project")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "project")
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "project")
	private List<Reward> rewards;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public int getRequiredBudget() {
		return requiredBudget;
	}

	public void setRequiredBudget(int requiredBudget) {
		this.requiredBudget = requiredBudget;
	}

	public long getGatheredBudget() {
		return gatheredBudget;
	}

	public void setGatheredBudget(long count) {
		this.gatheredBudget = count;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	
	
}
