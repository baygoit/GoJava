package ua.com.goit.gojava7.kickstarter.dto;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class PaymentDto {

    private Long paymentId;
    private String user;
    private String card;
    private Long amount;
    private Project project = new Project();

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
        return "PaymentDto [paymentId=" + paymentId + ", user=" + user
                + ", card=" + card + ", amount=" + amount +  ", project=" + project + "]";
    }

}
