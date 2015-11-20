package ua.com.goit.gojava7.kickstarter.model;

public class Project {
    private Category category;

    private final String name;

    private final String shortDescription;

    private final String history;

    private final String videoUrl;

    private final String description;

    private final int moneyNeeded;

    private int moneyDonated;

    private int daysLeft;

    public Project(String name, String shortDescription, String description, String history, String videoUrl,
                   int moneyNeeded, int daysLeft) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.history = history;
        this.videoUrl = videoUrl;
        this.description = description;
        this.moneyNeeded = moneyNeeded;
        this.moneyDonated = 0;
        this.daysLeft = daysLeft;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getHistory() {
        return history;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addMoneyDonated(int money) {
        this.moneyDonated += money;
    }
}
