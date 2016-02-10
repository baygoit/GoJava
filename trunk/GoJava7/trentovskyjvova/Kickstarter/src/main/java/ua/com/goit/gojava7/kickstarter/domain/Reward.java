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
	private Long id;
	
	@Column
	private Long projectId;
	@Column
	private Long pledge;
	@Column
	private String benefit;
	
	public Reward() {
		
	}
	
	public Reward(Long id, Long projectId) {
		this.id = id;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getPledge() {
		return pledge;
	}

	public void setPledge(Long pledge) {
		this.pledge = pledge;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

}
