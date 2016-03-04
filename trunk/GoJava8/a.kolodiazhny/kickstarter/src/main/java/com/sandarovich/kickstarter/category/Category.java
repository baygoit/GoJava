package com.sandarovich.kickstarter.category;

/**
 * @author Olexander Kolodiazhny
 */

public class Category {

    private final int id;
    private final String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return name;
    }
}
