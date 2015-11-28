package ua.com.goit.gojava7.kickstarter.domain;

public class Payment {
	private int id;
	private int projectId;
	private String name;
	private String cardNumber;
	private int pledge;
	
	public Payment() {

	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

}
