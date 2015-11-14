package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.PaymentSystem;

public class User {
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(UserSettings settings) {
		super();
		this.settings = settings;
	}
	private PaymentSystem paymentSystem;
	private UserSettings settings;

	public UserSettings getSettings() {
		return settings;
	}

	public void setSettings(UserSettings settings) {
		this.settings = settings;
	}

	public PaymentSystem getPaymentSystem() {
		// TODO Auto-generated method stub
		return paymentSystem;
	}

	public void setPaymentSystem(PaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

}
