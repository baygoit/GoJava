package com.kickstarter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preset_payment_amounts")
public class PaymentAmount {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;

	public PaymentAmount() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
