package ua.com.goit.gojava7.salivon.beans;

import java.util.Calendar;
import java.util.Date;

public class Project {

    private int id;
    private int idCategory;
    private String title;
    private String description;
    private int total;
    private int collectedAmount;
    private int numberOfDaysToImplement;
    private Date dateStart;
    private String historyProject;
    private String link;
    private String faq;

    public Project(String title, int total, int idCategory, int id) {
        setDateStart();
        description = "...description...";
        collectedAmount = 0;
        this.title = title;
        this.total = total;
        this.idCategory = idCategory;
        historyProject = "...history...";
        link = "...link...";
        faq = "...FAQ...";
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    private void setDateStart() {
        dateStart = new Date();

    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumberOfDaysToImplement() {
        return numberOfDaysToImplement;
    }

    public void setNumberOfDaysToImplement(int numberOfDaysToImplement) {
        this.numberOfDaysToImplement = numberOfDaysToImplement;
    }

    public String getHistoryProject() {
        return historyProject;
    }

    public void setHistoryProject(String historyProject) {
        this.historyProject = historyProject;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(int collectedAmount) {
        this.collectedAmount += collectedAmount;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq += faq + "\n";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfDaysToEnd() {
        long milSecondStart = dateStart.getTime();
        long milSecondEnd = Calendar.getInstance().getTimeInMillis();
        int numberOfDaysInWork = (int) (milSecondEnd - milSecondStart) / (1000 * 60 * 60 * 24);
        return numberOfDaysToImplement - numberOfDaysInWork;
    }

}
