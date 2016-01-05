package ua.com.goit.gojava7.kickstarter.models;

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
	@Column(name = "id")
	private Long rewardId;
	@Column
	private int amount;
	@Column
	private String reward;	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project = new Project();	

	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public void setProjectId(Long projectId) {
		project.setProjectId(projectId);
	}

	@Override
	public String toString() {
		return "rewardId: " + rewardId + "; Amount: " + amount + "; Reward: " + reward + "; projectId: " + getProjectId();
	}
}
