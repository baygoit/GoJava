package ua.com.goit.gojava7.kickstarter.models;

import java.util.ArrayList;
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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long projectId;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Long goal;
	@Column
	private Long pledged;
	@Column
	private Long daysToGo;
	@Column
	private String history;
	@Column
	private String link;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "category_id")
	private Category category = new Category();	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private List<Question> questions = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private List<Reward> rewards = new ArrayList<>();	

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public Long getGoal() {
		return goal;
	}

	public void setGoal(Long goal) {
		this.goal = goal;
	}

	public Long getPledged() {
		return pledged;
	}

	public void setPledged(Long pledged) {
		this.pledged = pledged;
	}

	public Long getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(Long daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	
	
	@Override
	public String toString() {
		return "id: " + projectId + "; name: " + name + "; description: " + description + "; goal: " + goal + "; pledged: "
				+ pledged + "; daysToGo: " + daysToGo + "; history: " + history + "; link: " + link + "; categoryId: " + category.getCategoryId();
	}
}