package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment{
    @Id @GeneratedValue
    @Column
	private int id;
    @Column
	private long cardNumber;
    @Column
	private String cardOwner;
    @Column
	private int projectId;
    @Column
	private long amount;
	
	   public Payment() {

	    }
	   
	public String getCardOwner() {
		return cardOwner;
	}
	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
	    return "Payment: CardOwner= " + getCardOwner() + " cardNumber= " + getCardNumber() + " projectId="+getProjectId() + " amount="+getAmount() + " id="+id;
	   
	}
}
