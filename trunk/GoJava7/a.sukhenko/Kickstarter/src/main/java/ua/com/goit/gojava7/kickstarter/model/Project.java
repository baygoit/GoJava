package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "projects")
@NamedQueries({
@NamedQuery(name = "Project.findByCategoryId", query = "SELECT pr FROM Project pr WHERE pr.category.categoryId = :categoryId"),
@NamedQuery(name = "Project.findByProjectName", query = "SELECT pr FROM Project pr WHERE pr.projectName = :projectName")
})


public class Project implements Serializable {

    private static final long serialVersionUID = 3601009349187745841L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(unique = true)

    private String projectName;
    @Column
    private String projectDescription;
    @Column
    private double moneyNeeded;
    @Column
    private String projectHistory;
    @Column
    private String demoLink;


    @ManyToOne
    @JoinColumn(name = "projectCategoryId")
    private Category category;

    //TODO: Try @Temporal
    // @Temporal(TemporalType.DATE) // Doesn't work yet
    @Type(type = "ua.com.goit.gojava7.kickstarter.util.LocalDateTimeUserType")
    @Column(name = "enddate")
    private LocalDateTime enddate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<Bonus> bonuses = new ArrayList<Bonus>();

    @OneToMany(mappedBy = "project")
    private List<Question> questionsAndAnswers;

    @OneToMany(mappedBy = "project")
    private List<Payment> payments = new ArrayList<>();

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public Project() {

    }

    public double getMoneyNeeded() {
        return moneyNeeded;
    }

    public void setMoneyNeeded(double moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    public String getProjectHistory() {
        return projectHistory;
    }

    public void setProjectHistory(String projectHistory) {
        this.projectHistory = projectHistory;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public List<Question> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(List<Question> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }
    
    @Override
    public String toString() {
        return "Project. projectName: " + projectName +
                "projectDescription: " + projectDescription + 
                "projectHistory: " + projectHistory + 
                "moneyNeeded: " + moneyNeeded + 
                "demoLink: " + demoLink +
                "id: " + id +
                "categoryId: " + category.getCategoryId() +
                "enddate: " + getEnddate();
    }
}
