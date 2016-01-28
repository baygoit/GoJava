package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "projects")
@NamedQuery(name = "Project.findByCategoryId", query = "SELECT pr FROM Project pr WHERE pr.category.categoryId = :categoryId")
public class Project implements Serializable {

    private static final long serialVersionUID = 3601009349187745841L;
    private static final String MINUTES_LEFT = " minutes to go";
    private static final String HOURS_LEFT = " hours to go";
    private static final String DAYS_LEFT = " days to go";
    private static final String SECONDS_LEFT = " seconds to go";
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

    @Temporal(TemporalType.DATE)
    //@Type(type = "ua.com.goit.gojava7.kickstarter.util.LocalDateTimeUserType")
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
    //TODO: Move to controller
    public String getProjectEndTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = getEnddate().atZone(zoneId).toEpochSecond();
        long time = epoch - System.currentTimeMillis() / 1000;
        String msg = +time + SECONDS_LEFT;
        if (time >= 86400) {
            msg = (time / 86400) + DAYS_LEFT;
        } else if ((time >= 3600) && ((time % 3600) == 0)) {
            msg = (time / 60 / 60) + HOURS_LEFT;

        } else if (time >= 60) {
            msg = (time / 60) + MINUTES_LEFT;
        }
        return msg;
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
}
