package com.sandarovich.kickstarter.model;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findByCategory", query = "SELECT p from Project as p WHERE p.category = :category"),
        @NamedQuery(name = "Project.isProjectExist", query = "SELECT COUNT(p) from Project as p WHERE p.id = :id"),
        @NamedQuery(name = "Project.findById", query = "SELECT p from Project as p WHERE p.id = :id")
})
public class Project {
    @OneToMany(mappedBy = "project")
    List<Payment> payments;

    @OneToMany(mappedBy = "project")
    @SortNatural
    List<Question> questions;

    @OneToMany(mappedBy = "project")
    @SortNatural
    List<Award> awards;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "required_budget")
    private double requiredBudget;
    @Transient
    private double gatheredBudget;
    @Column(name = "days_left")
    private int daysLeft;
    @Column(name = "video_link")
    private String videoLink;
    @Column(name = "history")
    private String history;

    public Project() {
    }

    public double getGatheredBudget() {
        return gatheredBudget;
    }

    public void setGatheredBudget(double gatheredBudget) {
        this.gatheredBudget = gatheredBudget;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public void setRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
}