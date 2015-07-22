package ua.goit.kyrychok.kickstarter.model;

public class Reward {
    private int amount;
    private String description;

    public Reward(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
