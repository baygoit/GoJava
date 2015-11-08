package goit.nz.kickstartermvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private int amountRequired;
	private int amountCollected;
	private String deadline;
	private Category category;
	private List<ProjectEvent> events;
	private String linkToVideo;
	private List<FAQ> faqs;
	private List<RewardOption> rewardOptions;
	private long id;

	public Project(String name) {
		this.name = name;
		description = "";
		amountRequired = 0;
		amountCollected = 0;
		deadline = "";
		linkToVideo = "";
		events = new ArrayList<>();
		faqs = new ArrayList<>();
		rewardOptions = new ArrayList<>();
	}

	public Project(String name, String desc, int required, int collected,
			String date) {
		this.name = name;
		description = desc;
		amountRequired = required;
		amountCollected = collected;
		deadline = date;
		linkToVideo = "";
		events = new ArrayList<>();
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
		int result = 0;
		if (!deadline.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			Date end = null;
			try {
				end = dateFormat.parse(deadline);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long diff = end.getTime() - System.currentTimeMillis();
			result = (int) (diff / 86400000);
		}
		return result;
	}

	public void addEvent(ProjectEvent event) {
		events.add(event);
	}

	public void setLink(String link) {
		linkToVideo = link;
	}

	public void addFAQ(FAQ faq) {
		faqs.add(faq);
	}

	public List<ProjectEvent> getEvents() {
		return events;
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

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
}
