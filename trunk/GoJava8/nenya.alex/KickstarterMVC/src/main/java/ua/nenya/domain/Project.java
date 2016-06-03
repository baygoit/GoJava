package ua.nenya.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Project.getByCategoryId", query = "select p from Project p where p.category.id=:categoryId order by p.name"),
	@NamedQuery(name = "Project.getProjects", query = "select p from Project p"),
	@NamedQuery(name = "Project.Count", query = "select count(p) from Project p where p.id=:projectId"),
	@NamedQuery(name = "Project.CountByName", query = "select count(p) from Project p where p.name=:projectName"),
	})
@Table(name = "PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.PERSIST)
	private List<Reward> rewards; 
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(long availableAmount) {
		this.availableAmount = availableAmount;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	
}
