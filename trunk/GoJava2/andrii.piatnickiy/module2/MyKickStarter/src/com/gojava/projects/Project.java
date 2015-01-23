package com.gojava.projects;

public class Project {
    private String name;
    private String desc;
    private int needSum;
    private int currentSum;
    private String daysLeft;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getNeedSum() {
        return needSum;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public Project(String name, String desc, int needSum, int currentSum,
            String daysLeft) {
        this.name = name;
        this.desc = desc;
        this.needSum = needSum;
        this.currentSum = currentSum;
        this.daysLeft = daysLeft;
    }
}
