package ua.nenya.domain;

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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@GenericGenerator(name = "project_id", strategy = "increment")
	@GeneratedValue(generator = "project_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name = "needed_amount")
	private int neededAmount;
	
	@Transient
	private long availableAmount;
	
	@Column(name = "remaining_days")
	private int remainingDays;
	
	@Column
	private String history;
	
	@Column
	private String video;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	private List<Payment> payments; 
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNeededAmount() {
		return neededAmount;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNeededAmount(int allAmount) {
		this.neededAmount = allAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
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

	public long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(long availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
