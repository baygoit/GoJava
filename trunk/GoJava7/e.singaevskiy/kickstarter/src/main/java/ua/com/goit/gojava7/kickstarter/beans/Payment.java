package ua.com.goit.gojava7.kickstarter.beans;

import java.sql.Date;

public class Payment {
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
        this.project = project;
        this.user = user;
        this.cardId = cardId;
        this.sum = sum;
        this.date = date;
    }
    
    public Payment(Project project, Reward reward, String user, long cardId, long sum, Date date) {
        this(project, user, cardId, sum, date);
        this.reward = reward;
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
        result = prime * result + (int) (cardId ^ (cardId >>> 32));
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((reward == null) ? 0 : reward.hashCode());
        result = prime * result + (int) (sum ^ (sum >>> 32));
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        if (cardId != other.cardId)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (project == null) {
            if (other.project != null)
                return false;
        } else if (!project.equals(other.project))
            return false;
        if (reward == null) {
            if (other.reward != null)
                return false;
        } else if (!reward.equals(other.reward))
            return false;
        if (sum != other.sum)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
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

    @Override
    public String toString() {
        return "Payment [user=" + user + ", cardId=" + cardId + ", sum=" + sum + ", project=" + project + ", reward="
                + reward + ", date=" + date + "]";
    }

}
