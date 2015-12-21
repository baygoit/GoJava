package ua.com.goit.gojava7.kickstarter.model;

public class Payment {
	private String cardOwner;
	private long cardNumber;
	private int rechargeAmount;
	private int idPayment;
	private int idParentProject;

	public Payment() {
		// default constructor
	}

	public int getRechargeAmount() {
		return this.rechargeAmount;
	}

	public long getCardNumber() {
		return this.cardNumber;
	}

	public String getCardOwner() {
		return this.cardOwner;
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public int getIdParentProject() {
		return idParentProject;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setRechargeAmount(int rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public void setIdParentProject(int idParentProject) {
		this.idParentProject = idParentProject;
	}

}
