package com.sandarovich.kickstarter;

/**
 * Quota
 */

public class Quota {
    private String author;
    private String quota;

    public Quota(String author, String quota) {
        this.author = author;
        this.quota = quota;
    }

    @Override
    public String toString() {
        return author + ": " + "\"" + quota + "\"";
    }
}
