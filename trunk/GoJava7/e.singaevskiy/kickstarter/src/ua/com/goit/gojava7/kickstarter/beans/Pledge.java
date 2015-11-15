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

}
