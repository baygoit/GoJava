package tyomsky.kickstarter.model;

public class Project {

    private String name;
    private String description;
    private int moneyNeeded;
    private int moneyCollected;
    private int daysLeft;
    private Category category;
    private String history = "";
    private String demoVideoLink = "";
    private String questionsAndAnswers = "";


    public Project(String name, String description, int moneyNeeded, int daysLeft, String demoVideoLink, Category category) {
        this.name = name;
        this.description = description;
        this.moneyNeeded = moneyNeeded;
        this.daysLeft = daysLeft;
        this.demoVideoLink = demoVideoLink;
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

    public void setMoneyCollected(int moneyCollected) {
        this.moneyCollected = moneyCollected;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDemoVideoLink() {
        return demoVideoLink;
    }

    public void setQuestionsAndAnswers(String questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public String getHistory() {
        return history;
    }

    public String getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }
}
