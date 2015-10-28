package ua.com.goit.kyrychok.domain;

public class Reward {
    private int amount;
    private String description;
    private int id;

    public Reward(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
