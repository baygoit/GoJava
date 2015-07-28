package goit.nz.kickstartermvc.dao;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private int amountRequired;
	private int amountCollected;
	private int daysToGo; // TODO change to Date class
	private Category category;
	private String projectEvents; // TODO extract new class
	private String linkToVideo;
	private List<FAQ> faqs;
	private List<RewardOption> rewardOptions;

	public Project(String name) {
		this.name = name;
		description = "";
		amountRequired = 0;
		amountCollected = 0;
		daysToGo = 0;
		projectEvents = "";
		linkToVideo = "";
		faqs = new ArrayList<>();
		rewardOptions = new ArrayList<>();
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
		faqs = new ArrayList<>();
		rewardOptions = new ArrayList<>();
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

	public void addEvents(String history) {
		projectEvents = history;
	}

	public void setLink(String link) {
		linkToVideo = link;
	}

	public void addFAQ(FAQ faq) {
		faqs.add(faq);
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

	public List<FAQ> getFAQ() {
		return faqs;
	}
	
	public void addPledgedAmount(int amount) {
		amountCollected += amount;
	}
	
	public void addRewardOption(RewardOption rewardOption) {
		rewardOptions.add(rewardOption);
	}
	
	public List<RewardOption> getRewardOptions() {
		return rewardOptions;
	}
}
