package ua.com.goit.gojava7.kickstarter.model;

public class CreditCard {
	
	private long cardId;
	private Type type;
	
	public enum Type {
		MasterCard, Visa;
	}
	
	public CreditCard(long cardId) {
		this.cardId = cardId;
	}
	
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	
	public long getCardId() {
		return cardId;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	

}
