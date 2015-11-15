package ua.com.goit.gojava7.kickstarter.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private String name;
    private long goalSum;
    private long balanceSum;
    private Date startDate;
    private Date endDate;
    private List<Category> categories = new ArrayList<>();
    private String description;
    private String videoUrl;
    private List<FAQ> questionsAndAnswers = new ArrayList<>();
    private User author;

    public Project() {
        // default bean constructor
    }

    public Project(String name, User author, Category category) {
        super();
        this.name = name;
        this.categories.add(category);
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGoalSum() {
        return goalSum;
    }

    public void setGoalSum(long goalSum) {
        this.goalSum = goalSum;
    }

    public long getBalanceSum() {
        return balanceSum;
    }

    public void setBalanceSum(long balanceSum) {
        this.balanceSum = balanceSum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public List<FAQ> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(List<FAQ> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public void addQuestionAndAnswer(FAQ questionAndAnswer) {
        this.questionsAndAnswers.add(questionAndAnswer);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public long daysLeft() {
        long ms = 0;
        if (getEndDate() != null) {
            ms = getEndDate().getTime() - System.currentTimeMillis(); 
        }
        return ms / (1000L * 60L * 60L * 24L);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Project \"" + name + "\" by " + author;
    }

    public void addFAQ(FAQ faq) {
        this.questionsAndAnswers.add(faq);
    }

}
