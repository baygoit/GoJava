package ua.com.goit.gojava7.kickstarter.domain;

import java.sql.Date;

public class Payment {
    private String user;
    private long cardId;
    private long sum;
    private int projectId;
    private int rewardId;
    private Date date;

    public Payment() {
        // default bean constructor
    }
    
    public Payment(int projectId, String user, long cardId, long sum, Date date) {
        this.projectId = projectId;
        this.user = user;
        this.cardId = cardId;
        this.sum = sum;
        this.date = date;
    }
    
    public Payment(int projectId, int rewardId, String user, long cardId, long sum, Date date) {
        this(projectId, user, cardId, sum, date);
        this.rewardId = rewardId;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (cardId ^ (cardId >>> 32));
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + projectId;
        result = prime * result + rewardId;
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
        if (projectId != other.projectId)
            return false;
        if (rewardId != other.rewardId)
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

    @Override
    public String toString() {
        return "Payment [user=" + user + ", cardId=" + cardId + ", sum=" + sum + ", projectId=" + projectId
                + ", rewardId=" + rewardId + ", date=" + date + "]";
    }

}
