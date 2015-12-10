package ua.com.goit.gojava7.kickstarter.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Project{
    private static final String MINUTES_LEFT        = " minutes left";
    private static final String HOURS_LEFT          = " hours left";
    private static final String DAYS_LEFT           = " days left";
    private static final String SECONDS_LEFT        = " seconds left";
    private String              projectName;
    private String              projectDescription;
    private double              moneyNeeded;
    private String              projectHistory;
    private String              demoLink;
    private Map<String, String> questionsAndAnswers = new HashMap<>();
    private int                 projectCategoryId;
    private String              categoryName;
    private double              pledged             = 0;
    private LocalDateTime       enddate;
    private PaymentBonus        paymentBonus        = new PaymentBonus();

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public Project() {

    }

    public Project(String projectName, String projectDescription, int projectCategoryId, LocalDateTime enddate) {
        super();
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.setProjectCategoryId(projectCategoryId);
        this.enddate = enddate;
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

    public int getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(int projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addBacker(double d) {
        pledged += d;

    }
}
