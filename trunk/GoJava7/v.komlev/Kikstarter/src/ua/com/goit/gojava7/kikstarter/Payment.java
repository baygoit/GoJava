package ua.com.goit.gojava7.kikstarter;

public class Payment {

	private String paymentUserName;
	private long paymentNumberCard;
	private int paymentEntered;

	public Payment(String paymentUserName, long paymentNumberCard, int paymentEntered) {
		this.paymentUserName = paymentUserName;
		this.paymentNumberCard = paymentNumberCard;
		this.paymentEntered = paymentEntered;
	}

	public String getPaymentUserName() {
		return paymentUserName;
	}

	public long getPaymentNumberCard() {
		return paymentNumberCard;
	}

	public int getPaymentEntered() {
		return paymentEntered;
	}

	public void setPaymentUserName(String paymentUserName) {
		this.paymentUserName = paymentUserName;
	}

	public void setPaymentNumberCard(long paymentNumberCard) {
		this.paymentNumberCard = paymentNumberCard;
	}

	public void setPaymentEntered(int paymentEntered) {
		this.paymentEntered = paymentEntered;
	}

}
