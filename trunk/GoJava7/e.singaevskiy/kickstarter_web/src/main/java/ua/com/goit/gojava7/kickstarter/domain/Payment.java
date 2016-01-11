package ua.com.goit.gojava7.kickstarter.domain;

import java.sql.Date;

public class Payment {
	private int id;
    private String user;
    private long cardId;
    private long sum;
    private Project project;
    private Reward reward;
    private Date date;

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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "Payment [id=" + id + ", user=" + user + ", cardId=" + cardId + ", sum=" + sum + ", project=" + project + ", reward=" + reward
				+ ", date=" + date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
