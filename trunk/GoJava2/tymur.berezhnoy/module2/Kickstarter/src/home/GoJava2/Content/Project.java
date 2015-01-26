package home.GoJava2.Content;

public class Project {
	
	private Category category;
	private String name;
	private String desription;
	private double requiredAmount;
	private double total;
	private int days;
	
	public Project(String name, String description, double requiredAmount, int days) {
		this.name = name;
		this.desription = description;
		this.requiredAmount = requiredAmount;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public void setNewName(String name) {
		this.name = name;
	}

	public String getDesription() {
		return desription;
	}

	public void setNewDesription(String desription) {
		this.desription = desription;
	}

	public double getRequiredAmount() {
		return requiredAmount;
	}

	public double getTotal() {
		return total;
	}

	public void setNewTotal(double total) {
		this.total = total;
	}
	
	public int getDays() {
		return days;
	}
}