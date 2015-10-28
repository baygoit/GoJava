package ua.com.sas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;

	@Column(name = "money_need")
	private int moneyNeed;
	
	@Column(name = "money_has")
	private int moneyHas;
	
	@Column(name = "days_left")
	private int daysLeft;

	private String history;
	
	@Column(name = "video_link")
	private String videoLink;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy = "project",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Faq> faqs;

	public List<Faq> getFaqs() {
		return faqs;
	}

	public void setFaqs(List<Faq> faqs) {
		this.faqs = faqs;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMoneyNeed() {
		return moneyNeed;
	}
	
	public void setMoneyNeed(int moneyNeed) {
		this.moneyNeed = moneyNeed;
	}

	public int getMoneyHas() {
		return moneyHas;
	}
	
	public void setMoneyHas(int moneyHas) {
		this.moneyHas = moneyHas;
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
	
	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideoLink() {
		return videoLink;
	}
	
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

}
