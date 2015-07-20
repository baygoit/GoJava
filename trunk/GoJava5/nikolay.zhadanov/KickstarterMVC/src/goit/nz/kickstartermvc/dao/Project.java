package goit.nz.kickstartermvc.dao;

public class Project {
	private String name;
	private String description;
	private int amountRequired;
	private int amountCollected;
	private int daysToGo; // TODO change to Date class
	private Category category;
	private String projectEvents; // TODO extract new class
	private String linkToVideo;
	private String fAQ; // TODO extract new class

	public Project(String name) {
		this.name = name;
		description = "";
		amountRequired = 0;
		amountCollected = 0;
		daysToGo = 0;
		projectEvents = "";
		linkToVideo = "";
		fAQ = "";
	}

	public Project(String name, String desc, int required, int collected,
			int days) {
		this.name = name;
		description = desc;
		amountRequired = required;
		amountCollected = collected;
		daysToGo = days;
		projectEvents = "";
		linkToVideo = "";
		fAQ = "";
	}

	public void setCategory(Category cat) {
		category = cat;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		if (description.isEmpty()) {
			return "...";
		}
		return description;
	}

	public int getGoalAmount() {
		return amountRequired;
	}

	public int getPledgedAmount() {
		return amountCollected;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setEvents(String history) {
		projectEvents = history;
	}

	public void setLink(String link) {
		linkToVideo = link;
	}

	public void setFAQ(String qa) {
		fAQ = qa;
	}

	public String getEvents() {
		if (projectEvents.isEmpty()) {
			return "...";
		}
		return projectEvents;
	}

	public String getLink() {
		if (linkToVideo.isEmpty()) {
			return "-/-";
		}
		return linkToVideo;
	}

	public String getFAQ() {
		if (fAQ.isEmpty()) {
			return "N/A";
		}
		return fAQ;
	}
	
	public void addPledgedAmount(int amount) {
		amountCollected += amount;
	}
}
