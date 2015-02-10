public class Project {
	private String name;
	private String description;
	private int requiredAmount;
	private int total;
	private int days;

	public Project(String name, String description, int requiredAmount,
			int total, int days) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public int getTotal() {
		return total;
	}

	public int getDays() {
		return days;
	}

	public String allInformation() {
		return name + "\n" + "Description: " + description + "\n"
					+ "Required Amount: " + requiredAmount + "\n" + "Total: "
					+ total + "\n" + "Days: " + days;
	}
}