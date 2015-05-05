package v01;

class Project {
	
	private String name;
	private String description;
	private int requiredAmount;
	private int alreadyCollected;
	private int daysLeft;
	
	
	public Project(String name, String description, int requiredAmount,
			int alreadyCollected, int daysLeft) {
		super();
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.alreadyCollected = alreadyCollected;
		this.daysLeft = daysLeft;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String shortDescription) {
		this.description = shortDescription;
	}
	public int getRequiredAmount() {
		return requiredAmount;
	}
	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}
	public int getAlreadyCollected() {
		return alreadyCollected;
	}
	public void setAlreadyCollected(int alreadyCollected) {
		this.alreadyCollected = alreadyCollected;
	}
	public int getDaysLeft() {
		return daysLeft;
	}
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
	
	public void viewProject() {
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Required amount: " + requiredAmount);
		System.out.println("Already collected: " + alreadyCollected);
		System.out.println("Days left: " + daysLeft);
	}
	
	
}