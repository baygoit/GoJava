package tyomsky.kickstarter;

public class Project {

    private String name;
    private String description;
    private int moneyNeeded;
    private int moneyCollected;
    private int daysLeft;
    private Category category;

    public Project(String name, String description, int moneyNeeded, int daysLeft, Category category) {
        this.name = name;
        this.description = description;
        this.moneyNeeded = moneyNeeded;
        this.daysLeft = daysLeft;
        this.category = category;
    }

    public Category getCategory() {
        return category;
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

    public int getMoneyCollected() {
        return moneyCollected;
    }

    public String getShortPresentation() {
        return name + " \n" +
                description + " \n" +
                "Need to collect - " + moneyNeeded +
                "$. Collected - " + moneyCollected +
                "$. Days left - " + daysLeft;
    }

    public void setMoneyCollected(int moneyCollected) {
        this.moneyCollected = moneyCollected;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
