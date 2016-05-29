package ua.nenya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "REWARD")
@NamedQueries({ 
			@NamedQuery(name = "Reward.getById", query = "select r from Reward r where r.id=:rewardId"),
			@NamedQuery(name = "Reward.getProjectByRewardId", query = "select r.project from Reward r where r.id=:rewardId"),
			@NamedQuery(name = "Reward.Count", query = "select count(r) from Reward r where r.id=:rewardId")
})
public class Reward{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	private Project project;
	
	@Column
	private String name;
	
	@Column
	@Range(min = 1, max = 2147483647)
	private int amount;
	
	@Transient
	@NotNull
	@Length(min = 2, max = 50)
	private String cardholderName;
	
	@Transient
	@NotNull
	private String cardNumber;
	
	@Column
	private String description;

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
