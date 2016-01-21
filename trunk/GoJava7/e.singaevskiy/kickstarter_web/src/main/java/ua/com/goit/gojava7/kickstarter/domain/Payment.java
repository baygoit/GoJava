package ua.com.goit.gojava7.kickstarter.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name="Payment.getAll", query="select entity from Payment as entity"),
	@NamedQuery(name="Payment.getByProject", query="select entity from Payment as entity where project_id = :project_id"),
	@NamedQuery(name="Payment.getSumByProject", query="select SUM(entity.sum) from Payment as entity where project_id = :project_id"),
	@NamedQuery(name="Payment.removeAll", query="delete from Payment")
	})
public class Payment {
	
	private static final int USERNAME_MIN_SIZE = 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	@Size(min=USERNAME_MIN_SIZE, 
		message="User name must have at least  " + USERNAME_MIN_SIZE + " characters length")
    private String user;
	
	@DecimalMin(value="99999999", message="Card ID must be positive numeric and have at least 9 characters length")
    private long cardId;
    
	@DecimalMin(value="1", message="Amount must be positive numeric")
    private long sum;
    
    private Date date;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="project_id", foreignKey=@ForeignKey(name="Payment_Project"))
    private Project project;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="reward_id", foreignKey=@ForeignKey(name="Payment_Reward"))
    private Reward reward;

    public Payment() {
        // default bean constructor
    }
    
    public Payment(Project project, String user, long cardId, long sum, Date date) {
        this.setProject(project);
        this.user = user;
        this.cardId = cardId;
        this.sum = sum;
        this.date = date;
    }
    
    public Payment(Project project, Reward reward, String user, long cardId, long sum, Date date) {
        this(project, user, cardId, sum, date);
        this.setReward(reward);
    }

    public long getCardId() {
        return cardId;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getSum() {
        return sum;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "Payment [id=" + id + ", user=" + user + ", cardId=" + cardId + ", sum=" + sum + ", project=" + project + ", reward=" + reward
				+ ", date=" + date + "]";
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

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

}
