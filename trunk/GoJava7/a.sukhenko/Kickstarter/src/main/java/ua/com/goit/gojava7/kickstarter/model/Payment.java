package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "payments")
@NamedQueries({
@NamedQuery(name="Payment.getByProjectId", query = "SELECT py FROM Payment py WHERE py.project.id = :projectId"),
@NamedQuery(name="Payment.getProjectPledged", query = "SELECT SUM(p.amount) from Payment p where p.project.id = :projectId"),
})

public class Payment implements Serializable{
    
 
    private static final long serialVersionUID = 1879167496607047970L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer     id;
    @Column(name = "cardNumber")
    private String  cardNumber;
    @Column
    private String  cardOwner;
    @Column(name = "projectId", insertable = false, updatable = false)
    private Integer     projectId;
    @Column(name = "amount")
    private String    amount;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "projectId")
    private Project project;

    public Payment(String cardNumber, String cardOwner, Project project, String amount) {
        super();
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
        this.project = project;
        this.amount = amount;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Payment() {

    }

    public String getCardOwner() {
        return cardOwner;
    }
    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Payment: CardOwner= " + getCardOwner() + " cardNumber= " + getCardNumber() + " projectId=" + getProjectId() + " amount=" + getAmount() + " id="
                + id;

    }
}
