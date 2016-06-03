package com.anmertrix.domain;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "payment")
@NamedQueries({ 
	@NamedQuery(name = "Payment.getPayments", query = "SELECT p from Payment p where p.project.id=:projectId"),
	@NamedQuery(name = "Payment.getGatheredBudget", query = "SELECT SUM(p.amount) FROM Payment p WHERE p.project.id = :projectId")
})
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@Column(name = "card_number")
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Length(min=13, max=16, message="length must be between 13 and 16")
	private String cardNumber;
	
	@Column(name = "cardholder_name")
	@NotNull
 	@Length(min=2, max=50, message="length must be between 2 and 50")
	private String cardholderName;
	
	@Column
	@Range(min = 1, max = 1000000, message="must be between 1 and 1000000")
	private int amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
}
