package ua.goit.kyrychok.kickstarter.model;

public class Reward {
    private Integer amount;
    private String description;

    public Reward(Integer amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
