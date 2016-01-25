package ua.com.goit.gojava7.kickstarter.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@NamedQueries({ @NamedQuery(name = "Payment.calculatePledgedForProject",
		query = "SELECT SUM(p.amount) FROM Payment p WHERE p.project = :project") })
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long paymentId;

	@Column
	private String user;

	@Column
	private String card;

	@Column
	private Long amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Project project = new Project();

	public Payment() {		
	}

	public Payment(String user, String card, Long amount, Project project) {
		this.user = user;
		this.card = card;
		this.amount = amount;
		this.project = project;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", user=" + user
				+ ", card=" + card + ", amount=" + amount +  ", project=" + project + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (paymentId ^ (paymentId >>> 32));
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
		Payment other = (Payment) obj;
		return this.paymentId == other.paymentId;
	}
}
