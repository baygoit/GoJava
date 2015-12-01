package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.payment.PaymentSystem;

public class User {
	private PaymentSystem paymentSystem;
	private UserSettings settings = new UserSettings();

	public User() {
	}

	public User(UserSettings settings) {
		this.settings = settings;
	}

	public UserSettings getSettings() {
		return settings;
	}

	public void setSettings(UserSettings settings) {
		this.settings = settings;
	}

	public PaymentSystem getPaymentSystem() {
		return paymentSystem;
	}

	public void setPaymentSystem(PaymentSystem paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

}
