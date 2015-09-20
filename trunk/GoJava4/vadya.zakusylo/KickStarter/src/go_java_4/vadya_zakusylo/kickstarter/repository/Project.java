package go_java_4.vadya_zakusylo.kickstarter.repository;

public class Project implements ProjectInterface {
	private String name;
	private String shortDescription;
	private double needMoney;
	private double currentMoney;
	private int daysLeft;
	private String history;
	private String urlVideo;
	private CategoryInterface category;

	public Project(String name, String shortDescription, double needMoney, int daysLeft,
			String history, String urlVideo) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.needMoney = needMoney;
		currentMoney = 0.0;
		this.daysLeft = daysLeft;
		this.history = history;
		this.urlVideo = urlVideo;
	}

	public void setCategory(CategoryInterface category) {
		if (this.category != null) {
			clearCategory();
		}
		this.category = category;
		category.addProject(this);
	}

	private void clearCategory() {
		category.removeProject(this);
	}

	public String getShortContent() {
		String shortContent = name + "\n\t" + shortDescription + "\n\tNeed money: " + needMoney
				+ "\tCurrent money: " + currentMoney + "\n\tDays left: " + daysLeft;
		return shortContent;
	}

	public String getFullContent() {
		String fullContent = getShortContent() + "\n\tHistory of the project: " + history
				+ "\n\tLook video: " + urlVideo;
		return fullContent;
	}

}
