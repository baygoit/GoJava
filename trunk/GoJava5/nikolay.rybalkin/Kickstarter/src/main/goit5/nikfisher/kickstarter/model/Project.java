package goit5.nikfisher.kickstarter.model;

public class Project {

    private String question;
    private String ansver;
    private String name;
    private String description;
    private int amount;
    private int exist;
    private int days;
    private Category category;
    private String history;
    private String video;
    private int stillNeeded;
    private int id;


    public Project(String name, int amount, int exist, int days, String description) {
        this.name = name;
        this.amount = 10000;
        this.days = days;
        this.description = description;
        this.exist = 0;
        this.history = null;
        this.video = null;
        this.question = null;
        this.ansver = null;
    }

    @Deprecated
    public Project(String name) {
        this.name = name;
    }

    public Project(int id, String name) {
        this(name);
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("Category [name = %s, id=  %s]", name,  id);
    }

    public Project() {

    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnsver(String ansver) {
        this.ansver = ansver;
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

    public int getAmount() {
        return amount;
    }

    public int getExist() {
        return exist;
    }

    public int getDays() {
        return days;
    }

    public String getHistory() {
        return history;
    }

    public String getVideo() {
        return video;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnsver() {
        return ansver;
    }

    public void donate(int amount) {
        this.exist += amount;
    }

    public void question(String question) {
        this.question = question;
    }

}
