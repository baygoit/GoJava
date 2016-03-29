package com.sandarovich.kickstarter.domain;

import java.util.List;

/**
 * Question
 */

public class Question {
    private long id;
    private String text;
    private List<Answer> answers;

    public Question(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }
}
