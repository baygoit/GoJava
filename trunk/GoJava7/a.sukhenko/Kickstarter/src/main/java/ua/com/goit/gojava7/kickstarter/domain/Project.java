package ua.com.goit.gojava7.kickstarter.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="projects")
public class Project{
    private static final String MINUTES_LEFT        = " minutes left";
    private static final String HOURS_LEFT          = " hours left";
    private static final String DAYS_LEFT           = " days left";
    private static final String SECONDS_LEFT        = " seconds left";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String              projectName;
    @Column
    private String              projectDescription;
    @Column
    private double              moneyNeeded;
    @Column
    private String              projectHistory;
    @Column
    private String              demoLink;
    private Map<String, String> questionsAndAnswers = new HashMap<>();
    // <many-to-one name="category" cascade="all" column="projectCategoryId"  class="ua.com.goit.gojava7.kickstarter.domain.Category" fetch="join">
    @ManyToOne(targetEntity=Category.class)
    private Category category;
    @Column
    private double              pledged             = 0;
    @Column
    private LocalDateTime       enddate;
    private PaymentBonus        paymentBonus        = new PaymentBonus();

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public Project() {

    }


    public double getMoneyNeeded() {
        return moneyNeeded;
    }

    @XmlElement
    public void setMoneyNeeded(double moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

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

    public String getFundedPercentage() {
        return (float) ((pledged * 100) / getMoneyNeeded()) + "%";
    }

    public String getProjectName() {
        return projectName;
    }

    @XmlAttribute
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    @XmlElement
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

    public Map<String, String> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(Map<String, String> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }

    public PaymentBonus getPaymentBonus() {
        return paymentBonus;
    }

    public void setPaymentBonus(PaymentBonus paymentBonus) {
        this.paymentBonus = paymentBonus;
    }

   
    public double getPledged() {
        return pledged;
    }

    public void setPledged(double d) {
        this.pledged = d;
    }

    public void updatePledged(double amount) {
        this.pledged += amount;
    }


    public void addBacker(double d) {
        pledged += d;

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
}
