package com.tyomsky.kickstarter.model;

public class Quote {

    private int id;
    private String presentation;

    public Quote(int id, String presentation) {
        this.id = id;
        this.presentation = presentation;
    }

    public int getId() {
        return id;
    }

    public String getPresentation() {
        return presentation;
    }

}
