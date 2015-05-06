package go_java_4.vadya_zakusylo.kickstarter;

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

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public double getNeedMoney() {
		return needMoney;
	}

	public double getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public String getUrlVideo() {
		return urlVideo;
	}
}
