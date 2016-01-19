package ua.com.goit.gojava7.kickstarter.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "credit_card_number")
	private long creditCardNumber;
	@Column(name = "pledge")
	private int pledge;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Payment : [ownerName=" + ownerName + ", creditCardNumber=" + creditCardNumber + ", pledge=" + pledge + "]";
	}

	@Override
	public boolean equals(Object that) {
		if (that == null) {
			return false;
		}
		if (!this.getClass().equals(that.getClass())) {
			return false;
		}

		Payment payment = (Payment) that;
		if (this.id == payment.getId() && this.ownerName.equals(payment.getOwnerName())
				&& this.creditCardNumber == payment.getCreditCardNumber() && this.pledge == payment.getPledge()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int paymentHashCode = 0;
		paymentHashCode = (id + ownerName + creditCardNumber + pledge).hashCode();
		return paymentHashCode;
	}
}
