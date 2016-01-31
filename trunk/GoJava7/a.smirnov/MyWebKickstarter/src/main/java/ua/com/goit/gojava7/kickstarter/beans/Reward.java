package ua.com.goit.gojava7.kickstarter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "reward")
@NamedQuery(name = "Reward.findProjectRewards", query = "SELECT r FROM Reward r WHERE r.project.id = :id") 
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "pledge")
	private int pledge;
	@Column(name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Reward : [pledge=" + pledge + ", description=" + description + "]";
	}

	@Override
	public boolean equals(Object that) {
		if (that == null) {
			return false;
		}
		if (!this.getClass().equals(that.getClass())) {
			return false;
		}

		Reward reward = (Reward) that;
		if (this.id == reward.getId() && this.pledge == reward.getPledge() && this.description.equals(reward.getDescription())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int rewardHashCode = 0;
		rewardHashCode = (id + pledge + description).hashCode();
		return rewardHashCode;
	}
}
