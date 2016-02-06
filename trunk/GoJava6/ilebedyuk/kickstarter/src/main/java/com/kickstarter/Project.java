package com.kickstarter;

/**
 * Created by Игорь on 06.02.2016.
 */
public class Project {
    private String name;
    private int amount;
    private int days;
    private Category category;
    private String description;
    private int exist;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDays() {
        return days;
    }

    public String getDescription() {
        return description;
    }

    public Project(String name, int amount, int days, String description) {
        this.name = name;
        this.amount = amount;
        this.days = days;
        this.description = description;
        this.exist = 0;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public int getExist() {
        return exist;
    }
}
