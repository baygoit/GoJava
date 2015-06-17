package vadyazakusylo.kickstarter.model;

public class Project {
	private String name;
	private String shortDescription;
	private double needMoney;
	private double currentMoney;
	private int daysLeft;
	private String urlVideo;

	public Project(String name, String shortDescription, double needMoney, double currentMoney,
			int daysLeft, String urlVideo) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.needMoney = needMoney;
		this.currentMoney = currentMoney;
		this.daysLeft = daysLeft;
		this.urlVideo = urlVideo;
	}

	public String getName() {
		return name;
	}

	public String getShortContent() {
		String shortContent = shortDescription + "\n\tNeed money: " + needMoney
				+ "\tCurrent money: " + currentMoney + "\n\tDays left: " + daysLeft;
		return shortContent;
	}

	public String getFullContent() {
		String fullContent = getShortContent() + "\n\tLook video: " + urlVideo;
		return fullContent;
	}
}