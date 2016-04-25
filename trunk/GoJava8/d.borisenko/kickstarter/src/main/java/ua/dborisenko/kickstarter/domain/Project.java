package ua.dborisenko.kickstarter.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table(name = "projects")
public class Project implements Comparable<Project> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String history;
    @Column(name = "required_sum")
    private int requiredSum;
    @Column(name = "days_left")
    private int daysLeft;
    @Column(name = "video_url")
    private String videoUrl;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Investment> investments;
    @OneToMany(mappedBy = "project")
    @SortNatural
    private Set<Question> questions;
    @OneToMany(mappedBy = "project")
    @SortNatural
    private Set<Reward> rewards;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setRequiredSum(int requiredSum) {
        this.requiredSum = requiredSum;
    }

    public int getRequiredSum() {
        return requiredSum;
    }

    public int getCollectedSum() {
        int collectedSum = 0;
        for (Investment investment : investments) {
            collectedSum += investment.getAmount();
        }
        return collectedSum;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setVideoUrl(String videoURL) {
        this.videoUrl = videoURL;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Set<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(Set<Reward> rewards) {
        this.rewards = rewards;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int compareTo(Project project) {
        return this.name.compareTo(project.getName());
    }

}
