package com.tyomsky.kickstarter;

public enum Position {
    MAIN_PAGE,
    CATEGORY_PAGE,
    PROJECT_PAGE;

    int id;

    public int getContentId() {
        return id;
    }

    public void setContentId(int id) {
        this.id = id;
    }
}
