package com.sandarovich.kickstarter.project;

import com.sandarovich.kickstarter.category.Category;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created Olexander Kolodiazhny 2016
 */

public class ProjectBuilder {

    private Project project;
    private final Projects projects;

    // Required fields
    private int id;
    private Category category;
    private String name;

    // Optional fields
    private String shortDescription = "<<Empty>>";
    private double goalAmount = 0d;
    private double collectedAmount = 0d;
    private Calendar goalDate = new GregorianCalendar(2016, 2, 1);
    private String videoLink = "http:\\\\www.google.com";
    private String history = "No history";
    private String questionsAnswers = "No Q&A";


    public ProjectBuilder() {
        this.projects = new Projects();
    }


    public ProjectBuilder forId(int id) {
        this.id = id;
        return this;
    }

    public ProjectBuilder andCategory(Category category) {
        this.category = category;
        return this;
    }

    public ProjectBuilder andName(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder andDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public ProjectBuilder build() {
        this.project = new Project(id, category, name, shortDescription,
                goalAmount, collectedAmount, goalDate, videoLink,
                history, questionsAnswers);
        this.add();
        return this;
    }

    private ProjectBuilder add() {
        projects.add(this.project);
        return this;
    }


    public Projects getProjects() {
        return this.projects;
    }

    public ProjectBuilder add(int id, Category category, String name, String shortDesription,
                              double goalAmount, double collectedAmount, Calendar goalDate, String videoLink,
                              String history, String questionsAnswers) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.shortDescription = shortDesription;
        this.goalAmount = goalAmount;
        this.collectedAmount = collectedAmount;
        this.goalDate = goalDate;
        this.videoLink = videoLink;
        this.history = history;
        this.questionsAnswers = questionsAnswers;
        this.add();
        return this;
    }


}
