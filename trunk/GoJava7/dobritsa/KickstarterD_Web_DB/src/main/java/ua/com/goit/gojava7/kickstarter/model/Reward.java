package ua.com.goit.gojava7.kickstarter.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long rewardId;

	@Column
	private Long amount;

	@Column
	private String reward;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Project project = new Project();	

	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getProjectId() {
		return project.getProjectId();
	}

	@Override
	public String toString() {
		return "Reward [rewardId=" + rewardId + ", amount=" + amount
				+ ", reward=" + reward + ", projectId=" + project.getProjectId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rewardId ^ (rewardId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reward other = (Reward) obj;

		if (this.rewardId != null & other.rewardId != null) {
			if (this.rewardId != other.rewardId) {
				return false;
			}
		}

		if (this.amount != null & other.amount != null) {
			if (this.amount != other.amount) {
				return false;
			}
		}

		if (this.reward != null & other.reward != null) {
			if (!this.reward.equals(other.reward)) {
				return false;
			}
		}
		return true;
	}
}
