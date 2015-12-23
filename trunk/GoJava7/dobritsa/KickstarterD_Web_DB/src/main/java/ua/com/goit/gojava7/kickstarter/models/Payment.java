package ua.com.goit.gojava7.kickstarter.models;

public class Payment {

	private Integer id;
	private String user = null;
	private String card = null;
	private Integer amount;
	private Integer projectId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return id + "; " + user + "; " + card + "; " + amount + "; " + projectId + "; ";
	}

}
