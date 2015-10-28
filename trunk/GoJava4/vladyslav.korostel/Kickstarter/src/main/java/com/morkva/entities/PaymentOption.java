package com.morkva.entities;

import com.morkva.model.dao.Identified;

/**
 * Created by vladyslav on 29.05.15.
 */
public class PaymentOption implements Identified<Integer> {

    private Integer id;
    private String description;
    private Integer amount;
    private Project project;

    public PaymentOption(String description, Integer amount, Project project) {
        this.description = description;
        this.amount = amount;
        this.project = project;
    }

    public PaymentOption() {
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
}
