package ua.com.goit.gojava7.kickstarter.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "short_description")
	private String shortDescription;
	@Column(name = "required_sum")
	private int requiredSum;
	@Column(name = "full_description")
	private String fullDescription;
	@Column(name = "link_on_video")
	private String linkOnVideo;
	@Column(name = "collected_sum")
	private long collectedSum;
	@Column(name = "days_left")
	private int daysLeft;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany
	private List<Payment> payments;
	@OneToMany
	private Set<Reward> rewards;
	@OneToMany
	private Set<Faq> faqs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getLinkOnVideo() {
		return linkOnVideo;
	}

	public void setLinkOnVideo(String linkOnVideo) {
		this.linkOnVideo = linkOnVideo;
	}

	public int getRequiredSum() {
		return requiredSum;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public long getCollectedSum() {
		return collectedSum;
	}

	public void setCollectedSum(long collectedSum) {
		this.collectedSum = collectedSum;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Set<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}

	public Set<Faq> getFaqs() {
		return faqs;
	}

	public void setFaqs(Set<Faq> faqs) {
		this.faqs = faqs;
	}

	@Override
	public String toString() {
		return "Project : [name=" + name + ", shortDescription=" + shortDescription + ", fullDescription=" + fullDescription
				+ ", requiredSum=" + requiredSum + ", collectedSum=" + collectedSum + ", daysLeft=" + daysLeft + "]";
	}

	@Override
	public boolean equals(Object that) {
		if (that == null) {
			return false;
		}
		if (!this.getClass().equals(that.getClass())) {
			return false;
		}

		Project project = (Project) that;
		if (this.id == project.getId() && this.name.equals(project.getName())
				&& this.shortDescription.equals(project.getShortDescription()) && this.requiredSum == project.getRequiredSum()
				&& this.fullDescription.equals(project.getFullDescription()) && this.linkOnVideo.equals(project.getLinkOnVideo())
				&& this.collectedSum == project.getCollectedSum() && this.daysLeft == project.getDaysLeft()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int quoteHashCode = 0;
		quoteHashCode = (id + name + shortDescription + requiredSum + fullDescription + linkOnVideo + collectedSum + daysLeft)
				.hashCode();
		return quoteHashCode;
	}
}
