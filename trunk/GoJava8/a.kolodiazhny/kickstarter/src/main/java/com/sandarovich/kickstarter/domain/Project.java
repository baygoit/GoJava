package com.sandarovich.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olexander Koldoiazhnhy 2016
 */

public class Project {
    private final int id;
    private final String name;
    private final String shortDesription;
    private final double requiredBudget;
    private final int daysLeft;
    private final String videoLink;
    private final String history;
    private double gatherdBudget;
    private List<Question> questions = new ArrayList<Question>();
    private List<Award> awards = new ArrayList<Award>();

    public Project(int id, String name, String shortDesription,
                   double requiredBudget, double gatherdBudget, int daysLeft, String videoLink,
                   String history, List<Question> questions, List<Award> awards) {
        this.id = id;
        this.name = name;
        this.shortDesription = shortDesription;
        this.requiredBudget = requiredBudget;
        this.gatherdBudget = gatherdBudget;
        this.daysLeft = daysLeft;
        this.videoLink = videoLink;
        this.history = history;
        this.questions = questions;
        this.awards = awards;
    }

    public List<Object> getProjectAsObjectArray() {
        List<Object> result = new ArrayList<Object>();
        result.add(id);
        result.add(name);
        result.add(shortDesription);
        result.add(requiredBudget);
        result.add(gatherdBudget);
        result.add(daysLeft);
        return result;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDesription() {
        return shortDesription;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public double getGatherdBudget() {
        return gatherdBudget;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public String getHistory() {
        return history;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Award> getAwards() {
        return awards;
    }

    //Temporary methods for Memory mode
    public void invest(double amount) {
        gatherdBudget += amount;
    }
    public void addQuestion(String question) {
        questions.add(new Question(question));
    }

}
