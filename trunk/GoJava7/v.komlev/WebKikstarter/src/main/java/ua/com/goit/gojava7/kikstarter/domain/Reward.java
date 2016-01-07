package ua.com.goit.gojava7.kikstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rewards")
public class Reward {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "seq_id", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private int id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private int projectId;

	@Column(name = "amount_donation")
	private int amountDonation;

	@Column(name = "reward")
	private String reward;

	public int getId() {
		return id;
	}

	public int getProjectId() {
		return projectId;
	}

	public int getAmountDonation() {
		return amountDonation;
	}

	public String getReward() {
		return reward;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setAmountDonation(int amountDonation) {
		this.amountDonation = amountDonation;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "Amount donation: " + amountDonation + "; reward: " + reward;
	}

}
