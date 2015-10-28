package com.tyomsky.kickstarter.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private int cost;

    private int balance;

    private String deadLine;

    private String videoLink;

    private String history;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @Cascade({CascadeType.SAVE_UPDATE})
    Category category;

    public Project() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public int getBalance() {
        return balance;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project(int id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Project(String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
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

}
