package ua.com.goit.gojava7.kickstarter.domain;

public class Payment{
	private int id;
	private long cardNumber;
	private String cardOwner;
	private int projectId;
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
