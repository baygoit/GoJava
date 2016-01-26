package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int projectId;
	@Column
	private int pledge;
	@Column
	private String benefit;
	
	public Reward() {
		
	}
	
	public Reward(int id, int projectId) {
		this.id = id;
		this.projectId = projectId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

}
