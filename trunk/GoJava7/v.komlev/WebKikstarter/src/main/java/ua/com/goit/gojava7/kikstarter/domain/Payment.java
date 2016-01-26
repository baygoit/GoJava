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
@Table(name = "payments")
public class Payment {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "seq_id", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "number_card")
	private long numberCard;

	@Column(name = "amount_donation")
	private int amountDonation;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private int projectId;

	public int getId() {
		return id;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getUserName() {
		return userName;
	}

	public long getNumberCard() {
		return numberCard;
	}

	public int getAmountDonation() {
		return amountDonation;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setUserName(String paymentUserName) {
		this.userName = paymentUserName;
	}

	public void setNumberCard(long paymentNumberCard) {
		this.numberCard = paymentNumberCard;
	}

	public void setAmountDonation(int amountDonation) {
		this.amountDonation = amountDonation;
	}

	@Override
	public String toString() {
		return "User name: " + userName + "; number card: " + numberCard + "; donation: " + amountDonation;
	}

}
