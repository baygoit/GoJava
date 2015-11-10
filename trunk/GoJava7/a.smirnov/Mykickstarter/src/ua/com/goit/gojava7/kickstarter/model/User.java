package ua.com.goit.gojava7.kickstarter.model;

public class User {

	private String name;
	private int password;
	private CreditCard creditCard;

	public User(String name, int password, CreditCard creditCard) {
		this.name = name;
		this.password = password;
		this.creditCard = creditCard;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	
	public int getPassword() {
		return password;
	}
	
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	

}
