package go_java_4.vadya_zakusylo.kickstarter.repository;

public class Project {
	private String name;
	private String shortDescription;
	private double needMoney;
	private double currentMoney;
	private int daysLeft;
	private String history;
	private String urlVideo;

	public Project(String name, String shortDescription, double needMoney, double currentMoney,
			int daysLeft, String history, String urlVideo) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.needMoney = needMoney;
		this.currentMoney = currentMoney;
		this.daysLeft = daysLeft;
		this.history = history;
		this.urlVideo = urlVideo;
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

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

}
