package ua.com.goit.gojava7.kickstarter.beans;

import java.util.Date;

public class Payment {
    private User user;
    private long cardId;
    private long sum;
    private Date date;

    public Payment(User user, long cardId, long sum, Date date) {
        this.user = user;
        this.cardId = cardId;
        this.sum = sum;
        this.date = date;
    }

    public long getCardId() {
        return cardId;
    }

    public void setUser(User user) {
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

    public User getUser() {
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
        if (sum != other.sum)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

}
