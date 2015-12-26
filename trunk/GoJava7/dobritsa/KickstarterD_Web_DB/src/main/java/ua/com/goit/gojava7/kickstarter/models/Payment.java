package ua.com.goit.gojava7.kickstarter.models;

public class Payment {

	private Long paymentId;
	private String user;
	private String card;
	private Integer amount;
	private Project project = new Project();

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getProjectId() {
		return project.getProjectId();
	}

	public void setProjectId(Long projectId) {
		project.setProjectId(projectId);;
	}

	@Override
	public String toString() {
		return "paymentId: " + paymentId + "; user: " + user + "; card: " + card + "; amount: " + amount + "; projectId: " + getProjectId() + ";";
	}
}
