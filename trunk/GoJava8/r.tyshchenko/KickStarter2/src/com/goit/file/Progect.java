package com.goit.file;

import java.util.Locale;

/**
 * Created by roman on 13.03.16.
 */
public class Progect {
    private String name;
    private int amount;
    private int days;
    private Locale.Category category;
    private String description;
    private int exist;
    private String history;
    private String demoVideo;
    private String questionAnswers;

    public Progect(String name, int amount, int days, Locale.Category category, String description, int exist, String history, String demoVideo, String questionAnswers) {
        this.name = name;
        this.amount = amount;
        this.days = days;
        this.category = category;
        this.description = description;
        this.exist = 0;
        this.history = null;
        this.demoVideo = demoVideo;
        this.questionAnswers = null;
    }
}
