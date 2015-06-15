package vadya_zakusylo.kickstarter.model;

public class ProjectImpl implements Project {
	private String name;
	private String shortDescription;
	private double needMoney;
	private double currentMoney;
	private int daysLeft;
	private String urlVideo;

	public ProjectImpl(String name, String shortDescription, double needMoney, double currentMoney,
			int daysLeft, String urlVideo) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.needMoney = needMoney;
		this.currentMoney = currentMoney;
		this.daysLeft = daysLeft;
		this.urlVideo = urlVideo;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getShortContent() {
		String shortContent = shortDescription + "\n\tNeed money: " + needMoney
				+ "\tCurrent money: " + currentMoney + "\n\tDays left: " + daysLeft;
		return shortContent;
	}

	@Override
	public String getFullContent() {
		String fullContent = getShortContent() + "\n\tLook video: " + urlVideo;
		return fullContent;
	}
}