package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Project {
    protected int id;

    private String name;

    private Category category;

    private String shortDescription;

    private String description;

    private String history;

    private String videoUrl;

    private int moneyNeeded;

    private int moneyDonated;

    private int daysLeft;

    private final List<String> questions;

    private final List<String> benefits;

    private List<Integer> sumForBenefit;

    public Project(String name, Category category, String shortDescription, String description, String history,
                   String videoUrl, int moneyNeeded, int daysLeft)
    {
        this.name = name;
        this.category = category;
        category.add(this);
        this.shortDescription = shortDescription;
        this.description = description;
        this.history = history;
        this.videoUrl = videoUrl;
        this.moneyNeeded = moneyNeeded;
        this.moneyDonated = 0;
        this.daysLeft = daysLeft;
        this.questions = new ArrayList<>();
        this.benefits = new ArrayList<>();
        this.sumForBenefit = Arrays.asList(1, 10, 40); // currently hardcoded
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getHistory() {
        return history;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getMoneyNeeded() {
        return moneyNeeded;
    }

    public int getMoneyDonated() {
        return moneyDonated;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public List<String> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public List<String> getBenefits() {
        return Collections.unmodifiableList(benefits);
    }

    public List<Integer> getSumForBenefit() {
        return sumForBenefit;
    }

    public void addMoneyDonated(int money) {
        moneyDonated += money;

        if (money < moneyNeeded) {
            moneyNeeded -= money;
        } else {
            moneyNeeded = 0;
        }
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public void addBenefitItem(String benefit) {
        benefits.add(benefit);
    }
}
