package ua.com.goit.gojava7.kickstarter;

public class PaymentSystem {
	private Double balance;
	private String paymentSystemName;
	private int paymentSystemID; 
	
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

	public boolean payMoney(Double amount) {
		return false;
		
		
	}

	public void putMoney(int i) {
		// TODO Auto-generated method stub
		
	}

	public void withdrawMoney(int i) {
		// TODO Auto-generated method stub
		
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

}
