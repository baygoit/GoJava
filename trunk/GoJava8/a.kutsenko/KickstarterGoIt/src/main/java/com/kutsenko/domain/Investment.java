package com.kutsenko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "investment")
@NamedQueries({
@NamedQuery(name = "Payment.getGatheredBudgetByProjectId", query = "SELECT SUM(p.amount) FROM investment as p WHERE p.project.id = :projectId"),
@NamedQuery(name = "Payment.getPaymentsByProjectId", query = "SELECT p from investment p where p.project.id=:projectId"),
})
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@Column(name = "cardholder_name")
	private String cardHolderName;

	@Column(name = "card_number")
	private String cardNumber;

	@Column
	private int amount;

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}