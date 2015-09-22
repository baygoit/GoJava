package goit.nz.kickstarter.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "PROJECTS")
public class Project {
	@Column
	private String name;
	@Column
	private String description;
	@Column(name = "AMOUNT_GOAL")
	private int amountRequired;
	@Column(name = "AMOUNT_PLEDGED")
	private int amountCollected;
	@Column
	private Date deadline;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.REMOVE })
	private List<ProjectEvent> events;
	@Column(name = "LINK_TO_VIDEO")
	private String linkToVideo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.REMOVE })
	private List<FAQ> faqs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.REMOVE })
	private List<RewardOption> rewardOptions;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public Project() {
	};

	public Project(long id, String name, String desc, int required,
			int collected) {
		this.id = id;
		this.name = name;
		description = desc;
		amountRequired = required;
		amountCollected = collected;
		linkToVideo = "";
		events = new ArrayList<>();
		faqs = new ArrayList<>();
		rewardOptions = new ArrayList<>();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDeadline() {
		return deadline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		if (description.isEmpty()) {
			return "...";
		}
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmountRequired() {
		return amountRequired;
	}

	public void setAmountRequired(int amount) {
		amountRequired = amount;
	}

	public int getAmountCollected() {
		return amountCollected;
	}

	public void setAmountCollected(int amount) {
		amountCollected = amount;
	}

	public int getDaysToGo() {
		int result = 0;
		if (deadline != null) {
			long diff = deadline.getTime() - System.currentTimeMillis();
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
		return linkToVideo;
	}

	public List<FAQ> getFaq() {
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

	public long getId() {
		return id;
	}
}
