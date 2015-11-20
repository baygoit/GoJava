package ua.com.goit.gojava7.kickstarter.beans;

import java.util.Date;

public class Pledge {
    private Reward reward;
    private Project project;
    private Payment payment;

    public Pledge() {
        // default bean constructor
    }
    
    public Pledge(Project project, Payment payment) {
        this.project = project;
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date paymentDate() {
        return payment.getDate();
    }
    
    public User paymentUser() {
        return payment.getUser();
    }
    
    public long paymentPledgeSum() {
        return payment.getSum();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((payment == null) ? 0 : payment.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((reward == null) ? 0 : reward.hashCode());
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
        Pledge other = (Pledge) obj;
        if (payment == null) {
            if (other.payment != null)
                return false;
        } else if (!payment.equals(other.payment))
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
        return true;
    }

}
