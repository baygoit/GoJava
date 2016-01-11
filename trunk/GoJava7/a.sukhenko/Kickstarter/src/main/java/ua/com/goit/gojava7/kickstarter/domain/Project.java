package ua.com.goit.gojava7.kickstarter.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
@Entity
@Table(name = "projects")
public class Project{
    private static final String MINUTES_LEFT        = " minutes to go";
    private static final String HOURS_LEFT          = " hours to go";
    private static final String DAYS_LEFT           = " days to go";
    private static final String SECONDS_LEFT        = " seconds to go";
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int                 id;
    @Column(unique = true)
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753
    private String              projectName;
    @Column
    private String              projectDescription;
    @Column
    private double              moneyNeeded;
    @Column
    private String              projectHistory;
    @Column
    private String              demoLink;
<<<<<<< HEAD
    private Map<String, String> questionsAndAnswers = new HashMap<>();
    // <many-to-one name="category" cascade="all" column="projectCategoryId"  class="ua.com.goit.gojava7.kickstarter.domain.Category" fetch="join">
    @ManyToOne(targetEntity=Category.class)
    private Category category;
    @Column
    private double              pledged             = 0;
    @Column
=======

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "projectCategoryId")
    private Category            category;

    @Type(type = "ua.com.goit.gojava7.kickstarter.util.LocalDateTimeUserType")
    @Column(name = "enddate")
>>>>>>> b0014930bf8740a544b0060d43ef290b3bc57753
    private LocalDateTime       enddate;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name="projectId") 
    private List<Bonus>          bonuses             = new ArrayList<Bonus>();

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Question>       questionsAndAnswers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @Cascade({CascadeType.SAVE_UPDATE})
    private List<Payment>        payments            = new ArrayList<>();

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
