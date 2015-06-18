package kickstarter.model.entity;

public class PaymentVariant {
	private int id;
	private int projectId;
	private int amount;
	private String description;

	public PaymentVariant(int id, int projectId, int amount, String description) {
		this.id = id;
		this.projectId = projectId;
		this.amount = amount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public int getProjectId() {
		return projectId;
	}

	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
}
