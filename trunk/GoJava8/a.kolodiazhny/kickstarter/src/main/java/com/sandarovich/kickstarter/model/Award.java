package com.sandarovich.kickstarter.model;

import javax.persistence.*;

@Entity
@Table(name = "award")
public class Award {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "amount")
    private double amount;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectid")
    private Project project;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
