package ua.com.goit.gojava7.kickstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "payments")
@NamedQuery(name="Payment.getByProjectId", query = "SELECT py FROM Payment py WHERE py.project.id = :projectId")
public class Payment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int     id;
    @Column(name = "cardNumber")
    private String  cardNumber;
    @Column
    private String  cardOwner;
    @Column(name = "projectId", insertable = false, updatable = false)
    private int     projectId;
    @Column(name = "amount")
    private long    amount;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "projectId")
    private Project project;

    public Payment(String cardNumber, String cardOwner, Project project, long amount) {
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
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Payment: CardOwner= " + getCardOwner() + " cardNumber= " + getCardNumber() + " projectId=" + getProjectId() + " amount=" + getAmount() + " id="
                + id;

    }
}
