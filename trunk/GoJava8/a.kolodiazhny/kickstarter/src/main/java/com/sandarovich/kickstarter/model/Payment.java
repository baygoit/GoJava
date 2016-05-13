package com.sandarovich.kickstarter.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Payment.getGatheredBudgetByProjectId", query = "SELECT SUM(p.amount) FROM Payment as p WHERE p.project.id = :projectId"),
        @NamedQuery(name = "Payment.getPaymentsByProjectId", query = "SELECT p from Payment p where p.project.id=:projectId"),
})
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "projectid")
    private Project project;

    @Column(name = "amount")
    private double amount;
    @Column(name = "cardholder")
    private String cardHolder;
    @Column(name = "cardnumber")
    private String cardNumber;

    public double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
