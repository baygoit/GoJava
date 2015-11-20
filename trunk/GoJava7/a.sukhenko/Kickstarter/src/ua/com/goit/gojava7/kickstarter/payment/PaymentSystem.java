package ua.com.goit.gojava7.kickstarter.payment;

public class PaymentSystem {
	protected String paymentSystemName;
	protected int paymentSystemID;

	public void setPaymentSystemName(String paymentSystemName) {
		this.paymentSystemName = paymentSystemName;

	}

	public String getPaymentSystemName() {
		return paymentSystemName;
	}

	public void setPaymentSystemID(int paymentSystemID) {
		this.paymentSystemID = paymentSystemID;

	}

	public int getPaymentSystemID() {
		return paymentSystemID;
	}

}
